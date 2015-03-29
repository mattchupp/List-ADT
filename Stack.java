/** @author Matt Chupp */

package lists;

public class Stack{

    // final value - cap for stack 
    protected final int DEFCAP = 100; 
    protected Object[] stack;  
    protected int topIndex = -1;

    /** Constructor */
    public Stack() {
        stack = new Object[DEFCAP];
    }

    public Stack(int maxSize) {      
        stack = new Object[maxSize];
    }

    /** check for empty stack 
     * if empty -> return true
     * if !empty -> return false
     */
    public boolean isEmpty() {  
        if(topIndex == -1) {
            return true;    
        } else {
            return false;           
        }
    }

    /** check for full stack 
     * if full -> return true
     * if !full -> return false
     */
    public boolean isFull() {
        if(topIndex == (stack.length - 1)) {
            return true;
        } else {
            return false;
        }
    }

    /** push into stack
     * if !isFull() add to stack
     * else return full stack
     */
    public void push(Object element) { 
        if(!isFull()) {          
            topIndex++;
            stack[topIndex] = element;          
        } else {           
            System.out.println("Full Stack");   
        }
    }

    /** pop stack
     * if not empty return topIndex
     * else -> empty stack
     */
    public void pop() {
        if(!isEmpty()) {         
            stack[topIndex] = null; 
            topIndex--;             
        } else {
            System.out.println("Empty Stack");
        }
    }

    /** returns the top of the stack */
    public Object top() {

        Object topOfStack = null; 

        if(!isEmpty()) {
            topOfStack = stack[topIndex];
        } else {
            System.out.println("Top attempted on empty stack");
        }
        return topOfStack; 
    }
}

