package jvmcpheron.courseplannerapp1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS implements Search{
    @Override
    public LinkedList<Course> runSearch(Graph g, Course c) {
        LinkedList<Course> path = new LinkedList<>();
        Queue<Vertex> q = new LinkedList<>();

        q.add(c);

        while (q.isEmpty() == false) {

            LinkedList<Edge> edges = g.getAdjacencyList().get(q.peek());

            //add destinations if not visited
            for (Edge edge : edges) {
                if (edge.getDst().getVisit() == false) {
                    if (!q.contains(edge.getDst())) {
                        q.add(edge.getDst());
                    }
                }
            }
            //add vertex to vector
            path.add((Course)q.peek());
            //mark as visited and remove from queue
            q.peek().setVisit(true);
            q.remove();
        }
        return path;
    }
}
