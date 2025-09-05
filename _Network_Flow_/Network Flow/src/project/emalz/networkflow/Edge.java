package w1948517.EmaMaloku.networkflow;

/**
 * Models an edge in the flow network, storing capacity, current flow, and reverse-edge link.
 *
 * @author emaam
 */
public class Edge {
    private final int to;
    private final int capacity;
    private int flow = 0;
    private Edge reverse;

    /**
     * Constructs an edge to a destination vertex with given capacity.
     *
     * @param to       destination vertex
     * @param capacity edge capacity
     */
    public Edge(int to, int capacity) {
        this.to = to;
        this.capacity = capacity;
    }

    /**
     * Returns the destination vertex of this edge.
     *
     * @return destination vertex index
     */
    public int getTo() {
        return to;
    }

    /**
     * Returns the capacity of this edge.
     *
     * @return edge capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the current flow through this edge.
     *
     * @return current flow
     */
    public int getFlow() {
        return flow;
    }

    /**
     * Sets the reverse edge (for the residual graph).
     *
     * @param reverse the reverse edge reference
     */
    void setReverse(Edge reverse) {
        this.reverse = reverse;
    }

    /**
     * Returns the reverse edge reference.
     *
     * @return reverse edge
     */
    public Edge getReverse() {
        return reverse;
    }

    /**
     * Calculates the residual capacity (capacity - flow).
     *
     * @return residual capacity
     */
    public int residualCapacity() {
        return capacity - flow;
    }

    /**
     * Augments flow by a specified amount and adjusts the reverse edge accordingly.
     *
     * @param amount bottleneck amount to augment
     */
    public void augment(int amount) {
        flow += amount;
        reverse.flow -= amount;
    }
}
