/*=============================================================================  
|   Source code:  ComputePI.java
|        Author:  Nathan Pabon 
|    Student ID:  5909334  
|    Assignment:  Program #1 Compute PI
|  
|        Course:  COP 3337 (Programming II)  
|       Section:  U02  
|    Instructor:  William Feild  
|      Due Date:  25 January 2018, at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|     Language:  Java 
|  Compile/Run:   
| 	javac ComputePI.java
|	java ComputePI
| 
|  +----------------------------------------------------------------------------  
|  
|  Description:  The program's purpose is to compute PI utilizing the Leibniz    
|                formula which can be found on page 29 in the book Big Java, 
|                Early Objects by Cay Horstmann. The program will calculate this 
|                up to the sixth decimal place. The formula is as follows:
|                   
|                π/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
|
|        Input:  No input is supplied by the user.  
|  
|       Output:  The program should output the expected value of PI (which in 
|                this case is 3.141593), the computed value of PI (which is 
|                computed using the Leibniz formula for PI), and number of 
|                iterations it took to get to this computation. These are all
|                printed on the screen in their own individual lines.
|  
|      Process:  The program goes through the following steps:
|                
|                1. The first iteration is counted before any computation 
|                   occurs.
|
|                2. It then checks if the iteration number is odd so that it may
|                   alternate between subtracting or adding to the computed 
|                   value as required by the Leibniz formula.
|
|                3. The program then adds 2 to the number to be divided by so 
|                   that each addition or subtraction happens with fractions
|                   with an odd number denominator.
|
|                4. It then checks if the absolute value of the difference 
|                   between the expected value and the computed value is less
|                   than DELTA, DELTA being the meaningful difference between
|                   PI and the expected value (this is determined to be 
|                   0.0000004). If it is true, the loop will stop.
|
|                5. The expected value, computed value, and number of iterations
|                   are displayed in each individual line.
|
|                   The computations rely on the Leibniz formula for PI.
|  
|   Required Features Not Included:  
|                All of the required features are in the program.  
|  
|   Known Bugs:  There does not appear to be any bugs in the code.  
|  *==========================================================================*/

package computepi;

//Library imported for the abs() method to find the absolute value.
import java.lang.Math;

/**
 * This class has the main method which computes PI using the Leibniz formula.
 * It computes PI up to a certain level of accuracy.
 * @author Nathan Pabon
 * @version 1.0
 */
public class ComputePI {
        
    public static void main(String[] args) {
        
        /*The expected value used to determine the delta of the expected value 
          and computed value. Printed at the end.*/
        final double EXPECTED_VALUE = 3.141593; 
        
        /*Delta constant is the difference between 3.1415926 and the expected
          value, this determines the most  meaningful difference. Used to 
          determine when to stop computation.*/
        final double DELTA = 0.0000004; 
        
        /*Counts the number of iterations in the loop.*/
        int iterationCount = 0; 
        
        /*Number to be divided by for the computation.*/
        double numberToBeDividedBy = 1.0;
        
        double computedValue = 0.0; /*Computed value of PI */
        
        /*Keeps the loop iterating until false.*/
        boolean continueToIterate = true;

        while(continueToIterate)
        {            
            
            iterationCount++;
            
            /*Checks if the iteration is odd to alternate between addition and
              subtraction.*/
            if (iterationCount % 2 == 1)
            {
                
                computedValue += 4 / numberToBeDividedBy;
                
            }
            else
            {
                
                computedValue -= 4 / numberToBeDividedBy;
                
            }
            
            /*This value increases by two with each loop so that the 
              computations above occur with only odd numbers starting from 1.0*/
            numberToBeDividedBy += 2;
            
            /*Checks if the absolute value of the difference is less than
              the DELTA constant 0.0000004, so that the program knows when to
              stop as soon as the desired computed value is reached.*/
            if (Math.abs(EXPECTED_VALUE - computedValue) < DELTA)
            {
                    
                continueToIterate = false;
                    
            }
            
        }        
        
        System.out.println("Expected Value: " + EXPECTED_VALUE);
        System.out.println("Computed Value: " + computedValue);
        System.out.println("Required Iterations: " + iterationCount);
        
    }    
}