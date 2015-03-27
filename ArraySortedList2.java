/** @author Matt Chupp */

package lists;

public class ArraySortedList2 extends List implements SortedListInterface {

    public ArraySortedList2() {
        super(); 
    }

    public ArraySortedList2(int origCap) {
        super(origCap); 
    }

    protected void find(Object target) {

        int first = 0; 
        int last = numElements - 1; 
        boolean moreToSearch = (first <= last); 
        int compareResult; 
        Comparable targetElement = (Comparable)target; 

        found = false; 

        while (moreToSearch && !found) {

            location = (first + last) / 2; 
            compareResult = targetElement.compareTo(list[location]); 

            if (compareResult < 0) {
                found = true; 
            }
            // target element is less than element at location
            else if (compareResult < 0) {
                last = location - 1; 
                moreToSearch = (first <= last); 
            } 
            // target element is great than element at location
            else {
                first = location + 1; 
                moreToSearch = (first <= last); 
            }
        }
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
