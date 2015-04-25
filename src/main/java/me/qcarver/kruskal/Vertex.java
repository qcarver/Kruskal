package me.qcarver.kruskal;

/**
 *
 * @author Quinn
 */
public class Vertex {
    public final char label;
    
    /**
     * C'tor to build Vertex, requires a single character label
     * @param label 
     */
    Vertex(char label){
        this.label = label;
    }
    
    /**
     * Vertices are compared by their labels
     * @param vertex the vertex to compare with this one
     * @return true if labels are teh same, flase otw
     */
    public boolean equals(Vertex vertex){
        return (this.label == vertex.label);
    }  
    
    //hide private constructor
    private Vertex(){label = 0x07;};
}
