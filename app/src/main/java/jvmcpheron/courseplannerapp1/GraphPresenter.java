package jvmcpheron.courseplannerapp1;

import android.util.Log;

import java.util.LinkedList;

public class GraphPresenter implements MVP_CoursePlanner_Contract.Presenter{


    private MVP_CoursePlanner_Contract.View view;

    public GraphPresenter(MVP_CoursePlanner_Contract.View v ) {
        // make sure to create your Graph here too...
        myManager = new GraphManager();
        view = v;
    }
    @Override
    public void searchGraph(String courseCode) {
        courseCode = courseCode.trim();
        boolean containsCourseCode = false;
        for(Vertex v : myManager.getMyGraph().getAdjacencyList().keySet()){
            Course c = (Course) v;

            //note: edittext doesnt produce exact string
            // so must use contains method here
            if(c.getCourseCode().contains(courseCode)){

                //make the course code the exact string now
                courseCode=c.getCourseCode();
                containsCourseCode = true;
                break;
            }
        }


        if(containsCourseCode==true){
            myManager.runNewSearch(courseCode);
            LinkedList<Course> myCourses = myManager.getCurrentPath();

            for(Course co : myCourses){
                Log.d("Debug",co.courseName);
            }
            view.updatePreReqStatus(myCourses);
        }else{
            Log.d("Debug", courseCode + " not in graph.");

        }

    }

    GraphManager myManager;
}
