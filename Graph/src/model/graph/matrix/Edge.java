package model.graph.matrix;

/**
 * <p>Class of Model <b>Edge</b>.</p>
 * <p>Class responsible for representing the <b>Edges</b> of the <b>Graph</b>.</p>
 * @author Leandro
 * @since  2020-11-12
 */
public class Edge {
    private final Integer source;
    private final Integer target;
    private final Integer weight;
    
    /**
     * Default Constructor Method of the Class.
     * @param source Source Vertex.
     * @param target Target Vertex.
     * @param weight Weight Vertex.
     */
    public Edge(Integer source, Integer target, Integer weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    
    /**
     * Method responsible for returning the Edge Source Vertex.
     * @return Edge Source Vertex..
     */
    public Integer getSource() {
        return this.source;
    }
    
    /**
     * Method responsible for returning the Edge Target Vertex.
     * @return Edge Target Vertex.
     */
    public Integer getTarget() {
        return this.target;
    }
    
    /**
     * Method responsible for returning the Edge Weight.
     * @return Edge Weight.
     */
    public Integer getWeight() {
        return this.weight;
    }
    
    @Override
    public String toString() {
        return this.source + " - " + this.target + " (" + this.weight + ")";
    }
}