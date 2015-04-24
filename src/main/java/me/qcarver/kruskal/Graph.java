/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.qcarver.kruskal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Quinn
 */
public class Graph {

    private List<Edge> edges = null;

    /**
     * adds an edge to the Graph
     * @param edge to add to the Graph
     */
    public void add(Edge edge) {
        if (edges == null) {
            edges = new ArrayList<Edge>();
        }
        edges.add(edge);
    }

    /**
     * answers the question, does this graph contain a particular vertex
     * @param vertex the vertex to query for
     * @return true if the graph contains the vertex
     */
    boolean has(Vertex vertex) {
        boolean has = false;
        for (Edge edge : edges) {
            if (edge.has(vertex)) {
                has = true;
            }
        }
        return has;
    }

    /**
     * returns the total weight of the graph
     * @return the total weight of the graph
     */
    int getWeight() {
        int weight = 0;
        for (Edge edge : edges) {
            weight += edge.weight;
        }
        return weight;
    }

    /**
     * returns all the vertices in the graph
     * @return all the vertices in the graph
     */
    Set<Vertex> getVertices() {
        Set<Vertex> vertices = null;
        if (edges != null) {
            vertices = new HashSet<Vertex>();
            for (Edge edge : edges) {
                vertices.add(edge.u);
                vertices.add(edge.v);
            }
        }
        return vertices;
    }
    
    /**
     * analogous to creating a min-heap
     * (though I'm not positive of the underlying container type)
     * @return 
     */
    Queue<Edge> getEdgesNonDecreasing(){
        Queue<Edge> edges = new PriorityQueue<Edge>();
        for (Edge edge : this.edges){
            edges.add(edge);
        }
        return edges;
    }
}
