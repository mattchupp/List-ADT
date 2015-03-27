package lists;

public class ArraySortedList3 extends List implements SortedListInterface {

    public ArraySortedList3() {
        super(); 
    }

    public ArraySortedList3(int origCap) {
        super(origCap); 
    }
    
    public void recFind(Comparable target, int fromLocation, int toLocation) {
        
        if (fromLocation > toLocation) {
            found = false; 
        } else {
            
            int compareResult; 
            location = (fromLocation + toLocation) / 2; 
            compareResult = target.compareTo(list[location]); 
            
            // base case 2
            if (compareResult == 0) {
                found = true; 
            } 
            // target is less than element at location 
            else if (compareResult < 0) {
                recFind(target, fromLocation, location - 1); 
            }
            // target is greater than element at location
            else {
                recFind(target, location + 1, toLocation); 
            }
        }
        
    }
    
    /** Searches list for an occurrence of an element e such that
     * target.equals(e). If successful, sets instance variables
     * found to true and location to the array indx of e. If 
     * not successful, sets found to false
     */
    protected void find(Object target) {

        Comparable targetElement = (Comparable)target; 
        found = false; 
        recFind(targetElement, 0, numElements - 1); 
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
