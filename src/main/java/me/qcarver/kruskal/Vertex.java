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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        } else {
            return equals((Vertex)obj);
        }
    }
    
    public boolean equals(Vertex vertex){
        return (this.label == vertex.label);
    }
    
    
    //hide private constructor
    private Vertex(){label = 'a';};
    
    
    
}
