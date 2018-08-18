/*==========================================================================
|   Source code: FastFibSequence.java
|
|         Class: FastFibSequence
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
| 	javac FastFibSequence.java
|	
|
|        Purpose:  The class serves the purpose calculating fibonacci numbers
                   using the fast fibonacci method. The next() method is called 
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
|   Constructors:  FastFibSequence()
                   FastFibSequence(int number)
|
|  Class Methods:  fib(int number), returns integer
|
|  Instance Methods:  next(), return integer
|
|  *==========================================================================*/
package fibdemo;

public class FastFibSequence implements Sequence
{
    
     private static int number;
     private static int[] auxiliaryArray;
     
     public FastFibSequence()
     {
         
         number = 1;
         auxiliaryArray = new int[40];
         
     }
     
     public FastFibSequence(int number, int amountOfNumbers)
     {
         
         FastFibSequence.number = number;
         auxiliaryArray = new int[amountOfNumbers + number];
         
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
      * Purpose: The method calculates a fibonacci number using the iterative
      *          algorithm.
      * 
      *          This algorithm tracks already calculated fibonacci numbers so
      *          that they do not repeat in calculation thus creating a quicker
      *          process.
      * 
      * @param number The number used to calculate.
      * @return The calculated fibonacci number.
      */
     private int fib(int number)
     {
         
         if(auxiliaryArray[number - 1] > 0)
         {
             
             return auxiliaryArray[number - 1];
             
         }
         
         if(number <= 2)
         {
             
             auxiliaryArray[number - 1] = 1;
             return 1;
             
         }
         else
         {
             
             auxiliaryArray[number - 1] = 
                     Math.addExact(fib(number - 1), fib(number - 2));
             return auxiliaryArray[number - 1];
             
         }
         
     }
    
}
