/** @author MattChupp */

package lists;

public class ArrayIndexedList extends List implements IndexedListInterface {

    public ArrayIndexedList() {
        super(); 
    }

    public ArrayIndexedList(int origCap) {
        super(origCap); 
    }

    /** Throws IndexOutOfBoundsException if passed an index argument
     * such that index < 0 or index > size(). 
     * Otherwise, adds element to list at position index; all current
     * elements at that position or higher have 1 added to their index
     */
    public void add(int index, Object element) {

        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Illegal index of " + index +
                    " passed to ArrayIndexList add method.\n");
        }

        if (numElements == list.length) {
            enlarge();
        }

        for (int i = numElements; i > index; i--) {
            list[i] = list[i -1]; 
        }

        list[index] = element; 
        numElements++; 
    }

    /** Throws IndexOutOfBoundsException if passed an index argument
     * such that index < 0 or index >= size()
     * Otherwise, replaces element on this list at position index and 
     * returns the replaces element
     */
    public Object set(int index, Object element) {

        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Illegal index of " + index +
                    " passed to ArrayIndexList set method.\n");
        }

        Object hold = list[index]; 
        list[index] = element; 
        return hold; 
    }

    /** Throws IndexOutOfBoundsException if passed an index argument
     * such that index < 0 or index >= size()
     * Otherwise, returns the element on this list at position index
     */
    public Object get(int index) {
        
        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Illegal index of " + index +
                    " passed to ArrayIndexList get method.\n");
        }
        
        return list[index]; 
    }

    /** If this list contains an element e such that e.equals(element)
     * the returns the index of the first such element. 
     * Otherwise, returns -1
     */
    public int indexOf(Object element) {

        find(element); 
        if (found) {
            return location;
        } else {
            return -1; 
        }
    }

    /** Throws IndexOutOfBoundsException if passed an index argument
     * such that index < 0 or index >= size()
     * Otherwise, removes element on this list at position index and 
     * returns the removed element; all current elements at positions 
     * higher than that position have 1 subtracted from their index.
     */
    public Object remove(int index) {

        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Illegal index of " + index +
                    " passed to ArrayIndexList remove method.\n");
        }
        
        Object hold = list[index]; 
        
        for (int i = index; i < numElements; i++) {
            list[index] = list[index + 1];
        }
        
        list[numElements] = null; 
        numElements--;
        return hold; 
    }
    
    /** Returns formatted string that represents this list */
    public String toString() {
        
        String listString = "List:\n"; 
        
        for (int i = 0; i < numElements; i++) {
            listString = listString + "[" + i + "] " + list[i] + "\n"; 
        }
        
        return listString; 
    }


}
