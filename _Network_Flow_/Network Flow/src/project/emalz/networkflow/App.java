package w1948517.EmaMaloku.networkflow;
/**
 *
 * @author emaam
 */

 import java.io.IOException;

/**
 * Entry point for the Network Flow application.
 */
public class App {
    public static void main(String[] args) throws IOException {
        // Parse the network from standard input
        Graph graph = Parser.parse(System.in);
        // Compute max flow from vertex 0 (source) to vertex n-1 
        int maxFlow = MaxFlow.compute(graph, 0, graph.size() - 1);
        System.out.println(maxFlow);
    }
}
