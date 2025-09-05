package w1948517.EmaMaloku.networkflow;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Quick parser test harness.
 * <p>
 * Runs Parser.parse on a small example and prints each forward edge.
 * </p>
 *
 * Example graph:
 *   4
 *   0 1 5
 *   1 2 3
 *   2 3 4
 *
 * Expected output:
 *   Edge from 0 to 1: cap = 5
 *   Edge from 1 to 2: cap = 3
 *   Edge from 2 to 3: cap = 4
 *
 * @author emaam
 */
public class ParserHarness {

    public static void main(String[] args) throws IOException {
        // Build example input: 4 vertices and 3 edges
        String input =
            "4\n" +
            "0 1 5\n" +
            "1 2 3\n" +
            "2 3 4\n" +
            "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Parse into Graph
        Graph g = Parser.parse(in);

        // Print only forward edges (capacity > 0)
        for (int u = 0; u < g.size(); u++) {
            for (Edge e : g.getEdges(u)) {
                if (e.getCapacity() > 0) {
                    System.out.println("Edge from " + u
                        + " to " + e.getTo()
                        + ": cap = " + e.getCapacity());
                }
            }
        }
    }
}
