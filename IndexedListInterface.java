/**   
 * @author Matt Chupp
 */

package lists;

public interface IndexedListInterface 
    extends ListInterface {

    void add(int index, Object element);
    // Throws IndexOutOfBoundsException if passed an index argument
    // such that index < 0 or index > size(). 
    // Otherwise, adds element to list at position index; all current
    // elements at that position or higher have 1 added to their index
    
    Object set(int index, Object element); 
    // Throws IndexOutOfBoundsException if passed an index argument
    // such that index < 0 or index >= size()
    // Otherwise, replaces element on this list at position index and 
    // returns the replaces element
    
    Object get(int index); 
    // Throws IndexOutOfBoundsException if passed an index argument
    // such that index < 0 or index >= size()
    // Otherwise, returns the element on this list at position index
    
    int indexOf(Object element); 
    // If this list contains an element e such that e.equals(element)
    // the returns the index of the first such element. 
    // Otherwise, returns -1
    
    Object remove(int index);
    // Throws IndexOutOfBoundsException if passed an index argument
    // such that index < 0 or index >= size()
    // Otherwise, removes element on this list at position index and 
    // returns the removed element; all current elements at postions 
    // higher than that position have 1 subtracted from their index. 
    
    
}
