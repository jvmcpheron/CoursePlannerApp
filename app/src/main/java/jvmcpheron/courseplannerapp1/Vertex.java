package jvmcpheron.courseplannerapp1;

public class Vertex {
    public Vertex() {
        vLabel = "Unassigned";
        visit = false;

    }

    public Vertex(String label) {
        vLabel = label;
        visit = false;

    }

    protected String vLabel;
    public String getLabel() {
        return vLabel;
    }


    protected boolean visit;
    public void setVisit(boolean v){visit = v;}
    public boolean getVisit(){return visit;}

}