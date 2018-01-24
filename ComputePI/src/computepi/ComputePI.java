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
|  Compile/Run:  [How to Compile and Execute this program, IN DETAIL.] 
| 	javac ComputePI.java
|	java ComputePI
| 
|  +----------------------------------------------------------------------------  
|  
|  Description:  The progam's purpose is to compute PI utilizing the Leibniz    
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
|                1. The first iteration is counted before any compution occurs.
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

import java.lang.Math;

/**
 *
 * @author npabon11
 */
public class ComputePI {

    /**
     * The main method encompasses the means to compute PI to a certain level
     * of accuracy, namely up to six decimal places. 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final double EXPECTED_VALUE = 3.141593;
        final double DELTA = 0.0000004;
        
        int iterationCount = 0;        
        double numberToBeDividedBy = 1.0;
        double computedValue = 0.0;
        
        boolean continueToIterate = true;

        while(continueToIterate)
        {            
            
            iterationCount++;
            
            if (iterationCount % 2 == 1)
            {
                
                computedValue += 4 / numberToBeDividedBy;
                
            }
            else
            {
                
                computedValue -= 4 / numberToBeDividedBy;
                
            }
            
            numberToBeDividedBy += 2;
                
            if (Math.abs(EXPECTED_VALUE - computedValue) < DELTA)
            {
                    
                continueToIterate = false;
                    
            }
            
            //FIXME: Printing for testing purposes, DELETE later
            System.out.println(computedValue);
            
        }
        
        
        System.out.println("Expected Value: " + EXPECTED_VALUE);
        System.out.println("Computed Value: " + computedValue);
        System.out.println("Required Iterations: " + iterationCount);
        
    }
    
}
