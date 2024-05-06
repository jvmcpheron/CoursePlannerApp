package jvmcpheron.courseplannerapp1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * class that implements Search interface
 * to find fastest path using Dijkstra's algorithm concepts
 */
public class Dijkstras implements Search {

    /**
     * runSearch method takes in graph and course
     * returns LL of fastest path
     */
    @Override
    public LinkedList<Course> runSearch(Graph g, Course c) {

        /**
         * hashmaps of distances, previous for Dijkstra's
         * LL of shortest path
         * pq is just a q because graph is unweighted
         */
        LinkedList<Course> path = new LinkedList<>();
        HashMap<Vertex, Integer> distances = new HashMap<>();
        HashMap<Vertex, Vertex> previous = new HashMap<>();
        Queue<Vertex> pq = new LinkedList<>();

        for(Vertex v : g.getAdjacencyList().keySet()){
            /**
             * since the shortest path should not be greater than the size
            */
            distances.put(v, g.getAdjacencyList().size()+1);
        }

        /**
         * distance from start to start is 0
         */
        distances.put(c, 0);

        pq.add(c);

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            for (Edge edge : g.getAdjacencyList().get(current)) {
                Integer tempDist = distances.get(current) + 1;
                Vertex neighbor = edge.getDst();

                /** if new dist is smaller than temp distance */
                if(distances.get(neighbor) > tempDist){

                    /** set new distance */
                    distances.put(neighbor, tempDist);

                    /** set new previous based on shortest path */
                    previous.put(neighbor, current);

                    /** make a new path with updated info */
                    Vertex tempPathV = neighbor;

                    Course cNeighbor = (Course) neighbor;

                    /** only generate new path if it connects to taken course */
                    if(cNeighbor.getTaken()==true){


                        /** generate path */
                        path = new LinkedList<>();
                        while(tempPathV != null){
                            Course tempPathC = (Course)tempPathV;

                            /** do not list a taken course */
                            if(tempPathC.getTaken() != true){
                                path.addFirst((Course)tempPathV);
                            }
                            tempPathV = previous.get(tempPathV);
                        }

                    }




                }

                /** if it hasn't been visited yet */
                if(!neighbor.getVisit()){

                    /** visit */
                    pq.add(neighbor);
                }
            }

            /** repeat until empty priority queue (all nodes visitted) */
        }


        /** at this point we should have a hashmap of distances and a hashmap of
        * previous nodes
        * Must turn it into a LinkedList of courses
        */
        g.resetGraphVisits();


        /** if no prereqs return this */
        if(path.isEmpty()){
            Course noPreReq = new Course("Prerequisites","No");
            path.add(noPreReq);
        }
        return path;
    }
}

