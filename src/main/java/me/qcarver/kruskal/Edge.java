package me.qcarver.kruskal;

/**
 *
 * @author Quinn
 */
public class Edge implements Comparable<Edge>{
    /**
     * the character which represents the u point of the edge
     */
    public final Vertex u;
    /**
     * the character which represents teh v point of the edge
     */
    public final Vertex v;
    /**
     * the weight of this edge
     */
    public final int weight;
    /**
     * construct a new edge
     * @param uLabel the character which represents the u point of the edge
     * @param vLabel the character which represents teh v point of the edge
     * @param weight the weight of the edge
     */
    Edge(Vertex u, Vertex v, int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    
    /**
     * does this edge include the vertex argument?
     * @param v the vertex to test and see if this edge has
     * @return true if the vertex passed is in the edge, false otw
     */
    boolean has(Vertex v){
        return((this.v.equals(v)) || (this.u.equals(v)));
    }

    /**
     * a comparator is implemented to help with 'min-heap' operations
     * @param t the edge to compare with this one
     * @return a number indicating the relative result of the comparison
     */
    public int compareTo(Edge t1) {
        Integer it = this.weight;
        Integer it1 = t1.weight;        
        return it.compareTo(it1);
    }
    
}
