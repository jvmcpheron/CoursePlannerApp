package jvmcpheron.courseplannerapp1;

import java.util.LinkedList;

/**
 * interface for searches
 * to allow easily switching between search types
 */
public interface Search {

    /**
     * runSearch method
     * @param g is graph to run search on
     * @param c is course you want prereqs for
     * @return returns a LL that is the path to course
     */
    public LinkedList<Course> runSearch(Graph g, Course c);


}
