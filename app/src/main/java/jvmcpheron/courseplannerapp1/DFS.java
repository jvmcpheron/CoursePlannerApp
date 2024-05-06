package jvmcpheron.courseplannerapp1;

import java.util.LinkedList;
import java.util.Stack;

public class DFS implements Search{
    @Override
    public LinkedList<Course> runSearch(Graph g, Course c) {
        LinkedList<Course> path = new LinkedList<>();
        Stack<Vertex> stack = new Stack<>();

        stack.push(c);

        while (!stack.isEmpty()) {
            Course current = (Course) stack.pop();

            //return if taken
            if(current.getTaken()==true){
                return path;
            }


            if (!current.getVisit()) {
                path.add(current);
                current.setVisit(true);

                LinkedList<Edge> edges = g.getAdjacencyList().get(current);
                for (Edge edge : edges) {
                    if (!edge.getDst().getVisit()) {
                        stack.push(edge.getDst());
                    }
                }
            }
        }

        return path;
    }
}
