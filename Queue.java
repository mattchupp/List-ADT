/** @author Matt Chupp */

package lists;

public class Queue{
    
    protected final int DEFCAP = 100; 
    protected Object[] queue; 
    protected int origCap; 
    protected int numElements = 0; 
    protected int front = 0; 
    protected int rear = -1;

    /** Constructor */
    public Queue() {
        queue = new Object[DEFCAP];
        rear = DEFCAP - 1; 
        origCap = DEFCAP; 
    }

    public Queue(int origCap) {
        queue = new Object[origCap]; 
        rear = origCap - 1; 
        this.origCap = origCap; 
    }

    /**
     * Creates a larger array 
     */
    private void enlarge() {

        // create a larger array
        Object[] larger = new Object[queue.length + origCap]; 

        //copy contents from the smaller array into the larger array 
        int currSmaller = front; 

        for (int currLarger = 0; currLarger < numElements; currLarger++) {

            larger[currLarger] = queue[currSmaller];
            currSmaller = (currSmaller + 1) % queue.length;
        }
        // update instance variables
        queue = larger; 
        front = 0; 
        rear = numElements - 1; 
    }

    /** adds an element to the rear of the queue */
    public void enqueue(Object element) {

        if(numElements == queue.length) {
            enlarge();
        }
        rear = (rear + 1) % queue.length; 
        queue[rear] = element; 
        numElements = numElements + 1; 
    }

    /**
     * Throws QueueUnderflowException if the queue is empty
     * if not empty, removes front element from queue and returns it
     */
    public Object dequeue() throws Exception {

        if(isEmpty()) {
            throw new Exception("Dequeue attempted on empty queue.");
        } else {
            Object toReturn = queue[front];
            queue[front] = null; 
            front = (front + 1) % queue.length; 
            numElements = numElements - 1; 
            return toReturn; 
        }
    }

    /** if the queue is empty return true */
    private boolean isEmpty() {
        return (numElements == 0); 
    }


}

