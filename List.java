package lists;

public class List {
    
    // default capcity
    protected final int DEFCAP = 100; 
    // original capacity
    protected int origCap;
    // array to hold this list's elements
    protected Object[] list;
    // number of elements in this list
    protected int numElements = 0; 
    // current position for iteration
    protected int currentPos;
    
    // set by find method
    protected boolean found; // true if elements found, otherwise false
    protected int location; // indicates location of element if found
    
    /** Main Constructor */
    public List() {
        
        list = new Object[DEFCAP];
        origCap = DEFCAP;  
    }
    
    /** Constructor
     * @param origCap = original capacity
     */
    public List(int origCap) {
        
        list = new Object[origCap];
        this.origCap = origCap;     
    }
    
    /** increments the capacity of the list by an amount
     *  equal to the original capacity
     *  Used by subclasses that provide an add method 
     */
    protected void enlarge() {
        
        // creat the larger array 
        Object[] larger = new Object[list.length + origCap];
        
        // copy the contents from the smaller array into the larger array
        for (int i = 0; i < numElements; i++) {
            larger[i] = list[i];
        }
        
        // reassign list reference
        list = larger; 
    }
    
    /** Searches list for an occurrence of an element e such that 
     *  e.equals(target). If successful, sets instance variables 
     *  found to true and location to the array index of e. If
     *  not successful, sets found to false. 
     *  @param target 
     */
    protected void find(Object target) {
        
        boolean moreToSearch; 
        location = 0; 
        found = false; 
        moreToSearch = (location < numElements);
        
        while (moreToSearch && !found) {
            if (list[location].equals(target)) {
                found = true; 
            } else {
                location++; 
                moreToSearch = (location < numElements); 
            }
        }   
    }
    
    /** 
     *  @return number of elements 
     */
    public int size() {
        return numElements; 
    }
    
    /**Returns true if this list contains an element e such 
     * that e.equals(element); otherwise returns false
     * 
     * @param element
     * @return if element is found 
     */
    public boolean contains(Object element) {
        
        find(element);
        return found; 
    }
    
    /**Removes an element e from this list such that e.equals(element)
     * and returns true; if no such element exists, returns false
     * 
     * @param element
     * @return if element is found and removed 
     */
    public boolean remove(Object element) {
        
        find(element);
        if (found) {
            for (int i = location; i <= numElements - 2; i++) {
                list[i] = list[i+1];
            }
            list[numElements -1] = null; 
            numElements--; 
        }
        
        return found; 
    }
    
    /** Returns an element e from this list such that e.equals(element)
     * if no such element exists, returns null
     * 
     * @param element
     * @return element in list if it exists, if not returns null
     */
    public Object get(Object element) {
        
        find(element);
        if (found) {
            return list[location];
        } else {
            return null; 
        }
    }
    
    /**
     * @return formatted string representing list 
     */
    public String toString() {
        
        String listString = "List:\n";
        for (int i = 0; i < numElements; i++) {
            listString = listString + " " + list[i] + "\n";
        }    
        return listString; 
    }
    
    /**Initializes current position for an iteration through this list
     * to the first element on this list
     */
    public void reset() {
        currentPos = 0; 
    }
    
    /** Preconditions: The list is not empty   
     *                 The list has been reset
     *                 The list has not been modified since most reset reset
     *                 
     * Returns the element at the current position on this list. 
     * If the current position is the last element, it advances the value
     * of the current position to the first element; otherwise, it advances
     * the value of the current position to the next element        
     * 
     * @return element at the current position on this list
     */
    public Object getNext() {
        
        Object next = list[currentPos];
        if (currentPos == (numElements - 1)) {
            currentPos = 0; 
        } else {
            currentPos++; 
        }
        return next; 
    }
}
