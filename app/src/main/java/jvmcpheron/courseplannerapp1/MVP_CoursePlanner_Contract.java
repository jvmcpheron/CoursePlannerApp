package jvmcpheron.courseplannerapp1;

import java.util.LinkedList;

/**
 * MVP CoursePlanner Contract
 * Interface for View and Presenter
 */
public interface MVP_CoursePlanner_Contract {

    /**
     * View contains pure virtual method updatePreReqStatus
     */
    interface View{
        /**
         * pure virtual method
         * @param preReq LL of preReqs to update status with
         */
        void updatePreReqStatus(LinkedList<Course> preReq);

    }

    /**
     * View contains pure virtual method searchGraph
     */
    interface Presenter{
        /**
         * pure virtual method
         * @param courseCode course code inputted used to search graph
         */
        void searchGraph(String courseCode);

    }
}
