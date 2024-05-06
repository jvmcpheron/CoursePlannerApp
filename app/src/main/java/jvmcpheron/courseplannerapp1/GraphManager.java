package jvmcpheron.courseplannerapp1;

import java.util.LinkedList;

public class GraphManager {
    private Graph myGraph;

    public Graph getMyGraph(){
        return myGraph;
    }
    private Search mySearch;
    public Search getMySearch(){return mySearch;}

    private LinkedList<Course> currentPath;

    GraphManager(){
        //using an interface here to hopefully make it easier to change out
        //graphs or sources of graphs later
        GraphMakerInterface graphMaker = new CSCourseGraph();
        myGraph = graphMaker.getGraph();

        mySearch = new Dijkstras();
        currentPath = new LinkedList<>();

    }


    //to allow future different kinds of searches
    void changeSearch(Search newSearch){
        mySearch = newSearch;
    }

    void runNewSearch(String courseCode){
        Course c = new Course();
        for(Vertex v : myGraph.getAdjacencyList().keySet()){
            Course x = (Course) v;

            //get vertex with matching course code
            if(x.getCourseCode()==courseCode){
                c=x;
                break;
            }
        }
        myGraph.resetGraphVisits();
        currentPath = mySearch.runSearch(myGraph, c);
    }

    //manager provides a path
    LinkedList<Course> getCurrentPath(){
        return currentPath;
    }

    //this manager should run searches on graph and then return the path for use


}
