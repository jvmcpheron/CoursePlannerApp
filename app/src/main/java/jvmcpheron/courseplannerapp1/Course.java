package jvmcpheron.courseplannerapp1;

/**
 * course class derived from vertex class
 */
public class Course extends Vertex{

    /**
     * holds taken bool, courseName string, courseCode string
     */
    protected boolean taken;
    protected String courseName;

    protected String courseCode;

    String getCourseName(){
        return courseName;
    }

    String getCourseCode(){
        return courseCode;
    }

    boolean getTaken(){
        return taken;
    }

    /**
     * setter for taken
     * @param s bool to set taken as
     */
    void setTaken(boolean s){
        taken = s;
    }


    /**
     * default constructor makes a course with courseCode="SRC"
     * and courseName="NULL" and taken=true
     */
    public Course() {
        taken = true;
        courseName = "NULL";
        courseCode = "SRC";
    }

    /**named courses mark taken as false
     * because they are not taken until marked taken
     * */

    /**
     * constructor for course
     * @param name set as courseName
     * @param code set as courseCode
     */

    public Course(String name, String code){
        courseName = name;
        courseCode = code;
        taken = false;
    }

}
