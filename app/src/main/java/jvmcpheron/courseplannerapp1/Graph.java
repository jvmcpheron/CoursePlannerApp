package jvmcpheron.courseplannerapp1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Graph class
 */
public class Graph {

    /**
     * stores adjacency list as HashMap of vertices and edges
     */
    private HashMap<Vertex, LinkedList<Edge>> adjacencyList;

    /**
     * getter for adjacency list
     * @return Hashmap adjacency list
     */
    public HashMap<Vertex, LinkedList<Edge>> getAdjacencyList(){return adjacencyList;}


    /**
     * default constructor
     */
    public Graph() {
        // Initialize adjacencyList here
        adjacencyList = new HashMap<>();
    }

    /**
     * method to reset visits (for searches)
     */
    public void resetGraphVisits(){
        for (Map.Entry<Vertex, LinkedList<Edge>> entry : adjacencyList.entrySet()){
            entry.getKey().setVisit(false);
        }
    }

    /**
     * adder for vertices (adds to adjacencyList as key)
     * @param v vertex to add
     */
    public void addVertex(Vertex v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new LinkedList<>());
        }else{
            System.out.println("Already a vertex!");
        }
    }

    /**
     * adder for edges (adds to adjacencyList to corresponding LL as value)
     * @param e edge to add
     */
    public void addEdge(Edge e) {
        //check if hashmap contains src and destination vertices
        //because I only want edges with both
        if(adjacencyList.containsKey(e.getSrc()) && adjacencyList.containsKey(e.getDst())){

            //check if list already contains edge, so we don't repeat
            if(!adjacencyList.get(e.getSrc()).contains(e)){
                adjacencyList.get(e.getSrc()).push(e);
            }else{
                System.out.println("Already an edge!");
            }
        }else{
            System.out.println("Edge does not meet program requirements!");
        }
    }
}
