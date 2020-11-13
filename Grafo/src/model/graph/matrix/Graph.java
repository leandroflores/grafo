package model.graph.matrix;

/**
 * <p>Class of Model <b>Graph</b>.</p>
 * <p>Class responsible for representing the <b>Graph</b>.</p>
 * @author Leandro
 * @since  2020-11-12
 */
public class Graph {
    private final Integer size;
    private final Integer[] positions;
    private final Integer[][] matrix;
    
    /**
     * Constructor Method of the Class.
     * @param size Number of Vertex.
     */
    public Graph(Integer size) {
        this.size      = size;
        this.positions = new Integer[this.size];
        this.matrix    = new Integer[this.size][this.size];
        this.init();
    }
    
    /**
     * Method responsible for initializing the Structures.
     */
    private void init() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++)
                this.matrix[i][j] = 0;
            this.positions[i] = -1;
        }
    }
    
    /**
     * Method responsible for inserting a New Edge.
     * @param source Vertex Source.
     * @param target Vertex Target.
     * @param weight Edge Weigth.
     */
    public void insertEdge(Integer source, Integer target, Integer weight) {
        this.matrix[source][target] = weight;
    }
    
    /**
     * Method responsible for returning if Edge already exists.
     * @param  source Vertex Source.
     * @param  target Vertex Target.
     * @return Edge Exists.
     */
    public boolean existsEdge(Integer source, Integer target) {
        return this.matrix[source][target] > 0;
    }
    
    /**
     * Method responsible for returning if Adjacents List is Empty.
     * @param  vertex Vertex.
     * @return Adjacents List is Empty.
     */
    public boolean adjacentsEmpty(Integer vertex) {
        for (int i = 0; i < this.size; i++) {
            if (this.matrix[vertex][i] > 0)
                return false;
        }
        return true;
    }
    
    /**
     * Method responsible for returning the First Adjacent of a Vertex.
     * @param  vertex Vertex.
     * @return First Adjacent.
     */
    public Edge getFirstAdjacent(Integer vertex) {
        this.positions[vertex] = -1;
        return this.getNextEdge(vertex);
    }
    
    /**
     * Method responsible for returning the Next Edge of a Vertex.
     * @param  vertex Vertex.
     * @return Next Edge of a Vertex.
     */
    public Edge getNextEdge(Integer vertex) {
        this.positions[vertex]++;
        while (this.positions[vertex] < this.size &&
               this.matrix[vertex][this.positions[vertex]] == 0)
            this.positions[vertex]++;
        return this.positions[vertex].equals(this.size) 
                ? null 
                : new Edge(vertex, this.positions[vertex], this.matrix[vertex][this.positions[vertex]]);
    }
    
    /**
     * Method responsible for removing a Edge.
     * @param  source Vertex Source.
     * @param  target Vertex Target.
     * @return Edge removed.
     */
    public Edge removeEdge(Integer source, Integer target) {
        if (this.matrix[source][target] > 0) {
            Edge   edge = new Edge(source, target, this.matrix[source][target]);
            this.matrix[source][target] = 0;
            return edge;
        }
        return null;
    }
    
    /**
     * Method responsible for printing the Matrix Header.
     * @return Matrix Header.
     */
    private String printHeader() {
        String header  = "    ";
        for (int i = 0; i < this.size; i++)
               header += i + "   ";
        return header + "\n";
    }
    
    /**
     * Method responsible for printing the Matrix Row.
     * @param  index Row Index.
     * @return Matrix Row.
     */
    private String printRow(Integer index) {
        String row = index + "  ";
        for (int i = 0; i < this.size; i++)
               row += this.matrix[index][i] + "  ";
        return row;
    }
    
    /**
     * Method responsible for printing the Matrix.
     * @return Matrix.
     */
    private String printMatrix() {
        String  matrix_  = "";
        for (int i = 0; i < this.size; i++)
                matrix_ += this.printRow(i);
        return  matrix_ + "\n";
    }
    
    @Override
    public String toString() {
        return this.printHeader() + this.printMatrix();
    }
}