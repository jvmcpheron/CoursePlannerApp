package jvmcpheron.courseplannerapp1;

/**
 * Edge class that connects two vertices
 */
public class Edge {

    /**
     * holds src vertex and dst vertex, with getters
     */
    private final Vertex src;
    public Vertex getSrc(){return src;}
    private final Vertex dst;
    public Vertex getDst(){return dst;}


    /**
     * can be weighted, default weight is 1
     * getWeight() method returns weight
     */
    private float weight;
    final float DEFAULT_WEIGHT = 1.0f;
    public float getWeight(){return weight;}

    /**
     * default constructor is private because
     * Edge must have vertices
     */
    private Edge() {
        src = null;
        dst = null;
        weight = 0.0f;
    }

    /**
     * Edge(s,d) is constructor for edge
     *
     * @param s is src vertex
     * @param d is dst vertex
     */
    public Edge(Vertex s, Vertex d) {
        src = s;
        dst = d;
        weight = DEFAULT_WEIGHT;
    }


    /**
     * weighted constructor
      * @param s is src vertex
     * @param d is dst vertex
     * @param w is weight
     */
    public Edge(Vertex s, Vertex d, float w) {
        src = s;
        dst = d;
        weight = w;
    }
}