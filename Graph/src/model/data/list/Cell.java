package model.data.list;

/**
 * <p>Class of Model <b>Cell</b>.</p>
 * <p>Class responsible for representing the <b>Cells</b> of the <b>List</b>.</p>
 * @author Leandro
 * @since  2020-11-12
 */
public class Cell {
    protected Object object;
    protected Cell   next;
    
    /**
     * Method responsible for returning the Cell Object.
     * @return Cell Object.
     */
    public Object getObject() {
        return this.object;
    }
    
    /**
     * Method responsible for returning the Next Cell.
     * @return Next Cell.
     */
    public Cell getNext() {
        return this.next;
    }
}