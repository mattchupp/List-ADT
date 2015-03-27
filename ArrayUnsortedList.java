/**   
 * @author Matt Chupp
 */

package lists;

public class ArrayUnsortedList extends List 
    implements UnsortedListInterface {

    public ArrayUnsortedList() {
        super(); 
    }
    
    public ArrayUnsortedList(int origCap) {
        super(origCap);
    }
    
    /**Adds element to list */
    public void add(Object element) {
        
        if (numElements == list.length) {
            enlarge(); 
        } 
        list[numElements] = element; 
        numElements++; 
    }
    
    /** Removes an element e from this list such that e.equals(element)
     * and returns true; if no such element exists, returns false
     */
    public boolean remove (Object element) {
        
        find(element); 
        if (found) {
            list[location] = list[numElements - 1];
            list[numElements - 1] = null; 
            numElements--; 
        }
        return found; 
    }
    
}
