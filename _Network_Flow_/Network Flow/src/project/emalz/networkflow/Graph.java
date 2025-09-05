package w1948517.EmaMaloku.networkflow;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a directed flow network using adjacency lists.
 *
 * @author emaam
 */
public class Graph {
    private final int size;
    private final List<List<Edge>> adjacency;

    /**
     * Constructs a graph with the given number of vertices (0 to size-1).
     *
     * @param size number of vertices
     */
    public Graph(int size) {
        this.size = size;
        adjacency = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjacency.add(new ArrayList<>());
        }
    }

    /**
     * Adds a directed edge with specified capacity and a reverse edge of capacity zero.
     *
     * @param from     source vertex index
     * @param to       destination vertex index
     * @param capacity edge capacity
     */
    public void addEdge(int from, int to, int capacity) {
        Edge forward = new Edge(to, capacity);
        Edge backward = new Edge(from, 0);
        forward.setReverse(backward);
        backward.setReverse(forward);
        adjacency.get(from).add(forward);
        adjacency.get(to).add(backward);
    }

    /**
     * Returns an unmodifiable list of outgoing edges from the given vertex.
     *
     * @param vertex vertex index
     * @return list of outgoing edges
     */
    public List<Edge> getEdges(int vertex) {
        return Collections.unmodifiableList(adjacency.get(vertex));
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return size of the graph
     */
    public int size() {
        return size;
    }
}