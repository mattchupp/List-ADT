/**
 * @author Matt Chupp
 */

package lists;

public class ArraySortedList extends List 
    implements SortedListInterface {

    public ArraySortedList() {
        super();
    }
    
    public ArraySortedList(int origCap) {
        super(origCap); 
    }
 
    /** Adds element to this list. */
    public void add(Comparable element) {
        
        Comparable listElement; 
        int location = 0; 
        boolean moreToSearch; 
        
        if (numElements == list.length) {
            enlarge(); 
        }
        
        moreToSearch = (numElements > 0); 
        
        while (moreToSearch) {
            listElement = (Comparable)list[location]; 
            if (listElement.compareTo(element) < 0) {
                location++; 
                moreToSearch = (location < numElements); 
            } else {
                moreToSearch = false; 
            }
        }
        
        for (int index = numElements; index > location; index--) {
            list[index] = list[index -1]; 
        }
        
        list[location] = element; 
        numElements++; 
    }  
    
}
