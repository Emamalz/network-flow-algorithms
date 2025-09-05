package w1948517.EmaMaloku.networkflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Parses a flow network from input and constructs the corresponding Graph.
 *
 * Expected format:
 *   First line: n (number of vertices)
 *   Subsequent lines: u v capacity
 *   Blank line or EOF ends the edge list
 * 
 * @author emaam
 */
public class Parser {

    /**
     * Reads the flow network data from the provided InputStream.
     *
     * @param in InputStream supplying the graph description
     * @return   a Graph built from the input
     * @throws IOException if the input is empty, malformed, or an I/O error occurs
     */
    public static Graph parse(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        // Read and parse vertex count
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) {
            throw new IOException("Invalid or empty input");
        }
        int n;
        try {
            n = Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            throw new IOException("Invalid vertex count: " + line, e);
        }

        Graph graph = new Graph(n);

        // Read edges until blank line or EOF
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                break;  // end of edge list
            }
            String[] parts = line.split("\\s+");
            if (parts.length < 3) {
                throw new IOException("Invalid edge format: " + line);
            }

            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);
            graph.addEdge(u, v, capacity);
        }

        return graph;
    }
}