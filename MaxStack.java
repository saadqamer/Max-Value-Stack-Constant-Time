package A1Q3;
import java.util.*;

/**
 * Specializes the stack data structure for comparable elements, and provides
 * a method for determining the maximum element on the stack in O(1) time.
 * @author jameselder
 */
public class MaxStack<E extends Comparable<E>> extends Stack<E> {

	
    private Stack<E> maxStack;	// main stack to be implemented declaration
    private Stack<E> maxStack2; // stack to store the maximum elements declaration
    E maxElement; //maximum element in the stack

    /**
     * Constructor for main stack and the maximum element stack
     * 
     * @author Saad Qamer
     */
    public MaxStack() { 
        maxStack = new Stack<>(); 
        maxStack2 = new Stack<>();
    }

   /**
    * Overridden push method to push elements onto the stack and
    * initialize the value of the maximum element in the stack if the 
    * element being pushed is greater than the current maximum element
    * 
    * @author Saad Qamer
    * @param element : the element being pushed onto the stack
    * @return the element that was pushed
    */
    public E push(E element) {
    	
    	
    	 if (maxStack.isEmpty())
         {
             maxElement = element;	//if stack is empty current element being pushed is maximum of stack
             maxStack.push(element);	//push element onto stack
             maxStack2.push(element);	//push maximum element onto maximum elements stack
             
             return element;
         }
  
         // if the new element is greaten that the current maximum element
         if (element.compareTo(maxElement)>0)
         {
             maxElement = element;		//replace maximum element
            maxStack.push(element);		//push element onto main stack
            maxStack2.push(element);	//push element onto maximum element stack
            return element;
         }
  
         else
         {
             maxStack.push(element);	//if element is equal to or less that maximum element push it onto the stack
         return element;
         }
    }

    /**
     * Pop the top element in the stack off the stack
     * and return the popped element
     * 
     * @author Saad Qamer
     * @exception EmptyStackException
     */
   public synchronized E pop() {
	 
       E t = maxStack.pop();	//variable to hold the current popped element
       
       if(maxStack.isEmpty())	//if stack is empty throw exception
       {
    	   throw new EmptyStackException();	
       }
       
       //if the current element being popped is biggeset element in the stack
       if(t.compareTo(maxElement)>= 0)
       {
    	   maxStack2.pop();		//pop the maximum elements stack to get the new maximum element
    	   maxElement = maxStack2.peek();	//set new maximum element to the element at the top off the maximum elements stack
    	  
       }

        return t;
    }

    /**
     * Method to return the maximum value on the stack
     * 
     * @author Saad Qamer
     * @return maxElement :Return the maximum element
     */
    public synchronized E max() {
    	return maxElement; 
    }
}