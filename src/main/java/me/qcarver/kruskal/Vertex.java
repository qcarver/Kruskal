package me.qcarver.kruskal;

/**
 *
 * @author Quinn
 */
public class Vertex {
    public final char label;
    
    Vertex(char label){
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass().isInstance(Vertex.class)){
            return equals((Vertex)o);
        }
        return false;
    }
    
    public boolean equals(Vertex vertex){
        return (this.label == vertex.label);
    }
    
    
    //hide private constructor
    private Vertex(){label = 'a';};
    
}
