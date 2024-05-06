package jvmcpheron.courseplannerapp1;


/**
 * GraphMaker used for project demonstration
 * Implements GMI to easily swap out with another graphmaker
 */
public class CSCourseGraph implements GraphMakerInterface{
    /** holds a graph */
    Graph myGraph;

    /**
     * default constructor makes graph for myGraph variable
     */

    public CSCourseGraph(){
        Course src = new Course();
        Course cs1 = new Course("Computer Science I", "CS1511");
        Course cs2 = new Course("Computer Science II", "CS1521");
        Course sad = new Course("Software Analysis and Design", "CS2511");
        Course disc = new Course("Discrete Structures", "CS2531");
        Course aut = new Course("Automata and Formal Languages", "CS3531");
        Course calc1 = new Course("Calculus I", "MATH1296");

        Course calc2 = new Course("Calculus II", "MATH1297");
        Course calc3 = new Course("Calculus III", "MATH3298");
        Course la = new Course("Linear Algebra", "MATH4326");
        Course vm = new Course("Vectors and Matrices", "MATH3326");
        Course ml = new Course("Machine Learning", "CS4232");



        Edge sadP1 = new Edge(sad, cs2);
        Edge cs2P1 = new Edge(cs2, cs1);
        Edge cs1P1= new Edge(cs1, src);
        Edge discP1= new Edge(disc, cs1);
        Edge discP2= new Edge(disc, calc1);
        Edge autP1= new Edge(aut, disc);
        Edge calc1P1 = new Edge (calc1, src);

        Edge calc2P1 = new Edge(calc2, calc1);
        Edge calc3P1 = new Edge(calc3, calc2);
        Edge laP1 = new Edge(la, calc3);
        Edge mlP1 = new Edge(ml, la);
        Edge vmP1 = new Edge(vm, calc1);
        Edge mlP2 = new Edge(ml, vm);


        myGraph = new Graph();

        myGraph.addVertex(src);
        myGraph.addVertex(cs1);
        myGraph.addVertex(cs2);
        myGraph.addVertex(sad);
        myGraph.addVertex(disc);
        myGraph.addVertex(aut);
        myGraph.addVertex(calc1);

        myGraph.addVertex(calc2);
        myGraph.addVertex(calc3);
        myGraph.addVertex(la);
        myGraph.addVertex(ml);
        myGraph.addVertex(vm);


        myGraph.addEdge(sadP1);
        myGraph.addEdge(cs2P1);
        myGraph.addEdge(cs1P1);
        myGraph.addEdge(autP1);
        myGraph.addEdge(discP1);
        myGraph.addEdge(calc1P1);
        myGraph.addEdge(discP2);

        myGraph.addEdge(calc2P1);
        myGraph.addEdge(calc3P1);
        myGraph.addEdge(laP1);
        myGraph.addEdge(vmP1);
        myGraph.addEdge(mlP1);
        myGraph.addEdge(mlP2);


    };

    /**
     * overrides GMI method getGraph()
     * @return returns myGraph
     */
    @Override
    public Graph getGraph() {
        return myGraph;
    }
}
