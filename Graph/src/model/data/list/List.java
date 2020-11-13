package model.data.list;

/**
 * <p>Class of Model <b>List</b>.</p>
 * <p>Class responsible for representing the <b>Lists</b>.</p>
 * @author Leandro
 * @since  2020-11-12
 */
public class List {
    private Cell first;
    private Cell last;
    private Cell position;
    
    /**
     * Constructor Method of the Class.
     */
    public List() {
        this.first      = new Cell();
        this.position   = this.first;
        this.last       = this.first;
        this.first.next = null;
    }
    
    /**
     * Method responsible for returning the Next Cell.
     * @return Next Cell.
     */
    public Object getNext() {
        this.position = this.position.next;
        return this.position != null ? this.position.object : null;
    }
    
    /**
     * Method responsible for returning the First Cell.
     * @return First Cell.
     */
    public Object getFirst() {
        this.position = this.first;
        return this.first;
    }
    
    /**
     * Method responsible for returning if List is Empty.
     * @return List is Empty.
     */
    public boolean isEmpty() {
        return this.first == this.last;
    }
    
    /**
     * Method responsible for inserting a New Object to List.
     * @param object New Object.
     */
    public void insert(Object object) {
        this.last.next   = new Cell();
        this.last        = this.last.next;
        this.last.object = object;
        this.last.next   = null;
    }
    
    /**
     * Method responsible for searching a Cell by Object Key.
     * @param  key Object Key.
     * @return Cell by Object Key.
     */
    public Cell search(Object key) {
        if (this.isEmpty() || key == null)
            return null;
        Cell current = this.first; 
        while (current.next != null) {
            if (current.next.object.equals(key))
                return current.next;
            current = current.next;
        }
        return null;
    }
}