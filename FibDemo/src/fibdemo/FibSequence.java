/*==========================================================================
|   Source code:  FibSequence.java
|
|         Class: FibSequence
|
|        Author:  
|    Student ID:  
|    Assignment:  Program #6 - Fibonacci Demo
|  
|        Course:  COP 3337 (Programming II)
|       Section:  
|    Instructor:    
|      Due Date:  19 April 2018, at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|      Language:  Java
|  Compile/Run: 
| 	javac FibSequence.java
|	
|
|        Purpose:  The class serves the purpose calculating fibonacci numbers
                   using the recursive method. The next() method is called 
                   multiple times in the FibDemo class to calculate fibonacci
                   numbers.
|
|  Inherits From:  None
|
|     Interfaces:  Implements Sequence.java
|
|  +-----------------------------------------------------------------------
|
|      Constants:  None
|
| +------------------------------------------------------------------------
|
|   Constructors:  FibSequence()
                   FibSequence(int number)
|
|  Class Methods:  fib(int number), returns integer
|
|  Instance Methods:  next(), returns integer
|
|  *==========================================================================*/

package fibdemo;

public class FibSequence implements Sequence
{
    
    private static int number;
    
    public FibSequence()
    {
        
        number = 1;
        
    }
    
    public FibSequence(int number)
    {
        
        FibSequence.number = number;
        
    }
    
    /**
     * Method: next()
     * 
     * Purpose: The method calls the fib() method with the starting value
     *          chosen by the user as a parameter to calculate a fibonacci 
     *          number. It then increments number so when next() is called again
     *          it will calculate the next fibonacci number. It finally returns
     *          the calculated fibonacci number.
     * 
     * @return The calculated fibonacci number.
     */
    public int next()
    {
        
        int fibNum = fib(number);
        number++;
        return fibNum;
        
    }
    
    /**
     * Method: fib(int number)
     * 
     * Purpose: The method calculates a fibonacci number using the recursive
     *          algorithm.
     * 
     *          This algorithm comes from the textbook Big Java Early Objects 
     *          pages 598 to 599.
     * 
     * @param number The number used to calculate
     * @return The calculated fibonacci number.
     */
    private int fib(int number)
    {
        
        if (number <= 2)
        {
            
            return 1;
            
        }
        else
        {
            
            return Math.addExact(fib(number - 1), fib(number - 2));
            
        }
        
    }
    
}
