/**   
 * @author Matt Chupp
 */

package lists;

public interface ListInterface {

    int size();
    // Returns the number of elements on this list

    boolean contains(Object element);
    // returns true if the list contains anelement e such that
    // e.equals(element); otherwise, returns false  

    boolean remove(Object element);
    // removes an element e from this list such that
    // e.equals(element) and returns true; if no such element
    // exists, returns false
    
    Object get(Object element);
    // Returns an element e from this list such that e.equals(element)
    // if no such element exists, returns null
    
    String toString();
    // returns a nicely formatted string that represents this list
    
    void reset(); 
    // initializes current position for an iteration through this list, 
    // to the first element on this list
    
    Object getNext(); 
    // Preconditions: The list is not empty
    //                The list has been reset
    //                The List has not been modified since most recent reset
    // Returns the element at the current position on this list. 
    // If the current position is the last element, then it advances the value
    // of the current position to the first element; otherwise, it advances
    // the value of the ucrrent position to the next element

}
