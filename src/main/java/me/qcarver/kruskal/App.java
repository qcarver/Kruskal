package me.qcarver.kruskal;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * The test in this main uses asserts. Make sure -ea ("enable asserts")
     * is part of your vm arguments in order to ensure that tests run correctly
     * @param args are ignored
     */
    public static void main( String[] args )
    {
        System.out.println("Kruskal's Algorithm...");
        
        App app = new App();
        
        //The graph on page 633 or Cormen's Intro to Alg. 3rd ed.
        Graph G = new Graph();
        G.add(new Edge(new Vertex('a'), new Vertex('b'), 4));
        G.add(new Edge(new Vertex('b'), new Vertex('c'), 8));
        G.add(new Edge(new Vertex('c'), new Vertex('d'), 7));
        G.add(new Edge(new Vertex('d'), new Vertex('e'), 9));
        G.add(new Edge(new Vertex('e'), new Vertex('f'), 10));
        G.add(new Edge(new Vertex('f'), new Vertex('g'), 2));
        G.add(new Edge(new Vertex('g'), new Vertex('h'), 1));
        G.add(new Edge(new Vertex('h'), new Vertex('a'), 8));
        G.add(new Edge(new Vertex('i'), new Vertex('c'), 2));
        G.add(new Edge(new Vertex('c'), new Vertex('f'), 4));
        G.add(new Edge(new Vertex('i'), new Vertex('g'), 6));
        G.add(new Edge(new Vertex('i'), new Vertex('h'), 7));
        G.add(new Edge(new Vertex('b'), new Vertex('h'), 11)); 
        G.add(new Edge(new Vertex('d'), new Vertex('f'), 14)); 
        
        Graph A = app.Kruskal(G);
        
        //does A have all the vertices?
        for (char  label = 'a'; label <= 'i'; label ++){
            assert(A.has(new Vertex(label)));
        }
               
        //is A's total weigtht 4+8+1+2+4+2+7+9? ...93 is total fail
        final int minWeight = 4+8+1+2+4+2+7+9;
        assert(A.getWeight() == minWeight);
        
        //if we got to this line without asserting(false), the test is passed
        System.out.println("Test Passed");
              
    }
       
    Set<HashSet<Vertex>> sets = null;
    
    void makeSet(Vertex vertex) {
        if (vertex != null) {
               //initialize
            HashSet<Vertex> newSet = new HashSet<Vertex>();
            newSet.add(vertex);
            boolean addNewSet = true;
            
            if (sets == null) {
                sets = new HashSet<HashSet<Vertex>>();
            } else {
                //check and see if we already have this
                for (Set<Vertex> set : sets) {
                    if (newSet.equals(set)) {
                        addNewSet = false;
                    }
                }
            }
            //if the set is unique, add it
            sets.add(newSet);
        }
    }
    
    /**
     * FIND-SET(x) returns a pointer to the representative of the (unique) 
     * set containing x. Cormen pg 562
     * @param the vertex we want to find in a set
     * @return the set which contained the vertex
     */
    Set<Vertex> findSet(Vertex vertex){
        Set<Vertex>  rv = null;
        for (Set<Vertex> set: sets){
            if (set.contains(vertex)){
                rv = set;
            }
        }
        return rv;
    }
    
    /**
     * UNION consolidates two sets (determined by vertices) into one
     * @param v1 a set which contains the vertex v1
     * @param v2 a set which contains the vertex v2
     */
    void union(Vertex v1, Vertex v2){
        Set<Vertex> s1 = findSet(v1);
        Set<Vertex> s2 = findSet(v2);
        
        assert(s1 != null);
        assert(s2 != null);
        
        s1.addAll(s2);
        sets.remove(s2);
    }
    
    Graph Kruskal(Graph G) {
        //Make a new graph for our resulting minimum spanning tree
        Graph A = new Graph();
        //make mini set of size 1, for each vertex v exists as a vertex in G
        for (Vertex v : G.getVertices()) {
            makeSet(v);
        }
        //for each edge, smallest first
        for (Edge edge : G.getEdgesNonDecreasing()) {
            //if the end point bridges the two sets
            if (findSet(edge.u) != findSet(edge.v)) {
                //add the edge to the MST
                A.add(edge);
                //update the sets
                union(edge.u, edge.v);
            }
        }
        return A;
    }
    
    
    
}
