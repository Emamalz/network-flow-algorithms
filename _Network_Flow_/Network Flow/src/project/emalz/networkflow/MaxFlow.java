package w1948517.EmaMaloku.networkflow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements the Edmonds–Karp algorithm to compute maximum flow.
 *
 * @author emaam
 */
public class MaxFlow {

    /**
     * Computes maximum flow from source to sink.
     *
     * @param graph the flow network
     * @param s     source vertex index
     * @param t     sink vertex index
     * @return      the value of the maximum flow
     */
    public static int compute(Graph graph, int s, int t) {
        int flow = 0;
        int n = graph.size();
        Edge[] parentEdge = new Edge[n];

        while (true) {
            // BFS to find the shortest augmenting path
            Arrays.fill(parentEdge, null);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(s);
            parentEdge[s] = new Edge(s, 0);  // mark source as visited

            while (!queue.isEmpty() && parentEdge[t] == null) {
                int u = queue.poll();
                for (Edge e : graph.getEdges(u)) {
                    int v = e.getTo();
                    if (parentEdge[v] == null && e.residualCapacity() > 0) {
                        parentEdge[v] = e;
                        queue.offer(v);
                    }
                }
            }

            // no more augmenting paths
            if (parentEdge[t] == null) {
                break;
            }

            // find bottleneck capacity along the path
            int bottleneck = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parentEdge[v].getReverse().getTo()) {
                bottleneck = Math.min(bottleneck, parentEdge[v].residualCapacity());
            }

            // augment flow along the path
            for (int v = t; v != s; v = parentEdge[v].getReverse().getTo()) {
                parentEdge[v].augment(bottleneck);
            }

            flow += bottleneck;
        }

        return flow;
    }
}