/*============================================================================
|   Source code: Die.java
|
|         Class: Die 
|
|        Author:  
|    Student ID:  
|    Assignment:  Program #3 - Craps
|  
|        Course:  COP 3337 (Programming II)
|       Section:  
|    Instructor:    
|      Due Date:  20 February 2018, at the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|        Language:  Java
|      Compile: 
|
|	Assuming you only want to compile the Die class
|
| 	javac Die.java
|
|        Purpose:  The purpose of this class is to simulate the rolling of a
|                  single die.
|
|  Inherits From:  None
|
|     Interfaces:  None
|
| +-----------------------------------------------------------------------
|
|      Constants:  SHIFT_BY_ONE is the value used in the return of rollDie()
|                  to shift the randomly generated value from a range of, for
|                  example, 0 - 5 to 1 - 6 if an input of 6 was passed. 
|                  DIE_LOWER_BOUND and DIE_UPPER_BOUND are bounds used to 
|                  check if a sidesInput of less than 3 or greater than 100 
|                  was passed in rollDie().
|
| +-----------------------------------------------------------------------
|
|   Constructors:  Craps(), no arguments
|
|  Class Methods:       None
|
|  Instance Methods:  
|                       1. rollDie(sidesInput), returns integer
|                      
|
| *==========================================================================*/
package craps;

/* Random imported to generate random numbers for dice rolls.*/
import java.util.Random;

public class Die 
{
    
    private final int SHIFT_BY_ONE = 1;
    private final int DIE_LOWER_BOUND = 3;
    private final int DIE_UPPER_BOUND = 100;
    
    private Random die;
    private int sides;
    
    public Die()
    {
        
        die = new Random();
        sides = 6;
        
    }
    
    /**
     * Method: rollDie(sidesInput)
     * 
     * Purpose: The method simulates the rolling of a die. It checks if the 
     * passed input value sidesInput is less than the lower bound or more
     * than the higher bound and sets it to the respective bound values. 
     * Otherwise sides is set to the sidesInput.
     * 
     * @param sidesInput The amount of sides for a die.
     * @return Randomly generated number from 1 to number of chosen sides.
     */
    public int rollDie(int sidesInput)
    {
        
        if (sidesInput < DIE_LOWER_BOUND)
        {
            
            sides = 3;
            
        }
        else if (sidesInput > DIE_UPPER_BOUND)
        {
            
            sides = 100;
            
        }
        else
        {
            
            sides = sidesInput;
            
        }
        
        return die.nextInt(sides) + SHIFT_BY_ONE;
        
    }
    
}
