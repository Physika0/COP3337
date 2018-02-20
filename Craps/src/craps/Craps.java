/*============================================================================
|   Source code: Craps.java
|
|         Class: Craps 
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
|	Assuming you only want to compile the Craps class
|
| 	javac Craps.java
|
|        Purpose:  The purpose of this class is to simulate a game of Craps 
|                  which is mainly done in the playGame() method. Other methods
|                  either simulate dice rolling such as rollDice, resetting the
|                  game (resetGame()), or returning stats of each game to be 
|                  used in the analyzer.
|
|  Inherits From:  None
|
|     Interfaces:  None
|
| +-----------------------------------------------------------------------
|
|      Constants:  NATURAL and YOLEVEN are constants used in place of the values
|                  that would be considered winning rolls on the coming out 
|                  roll. SNAKE_EYES, ACE_DEUCE, and BOX_CARS are values which 
|                  would be considered losing rolls when coming out. Finally,
|                  TWO_DICE and SIX_SIDES are merely value passed into the 
|                  rollDice() method to simulate the rolling of two six sided
|                  dice.
|
| +-----------------------------------------------------------------------
|
|   Constructors:  Craps(), no arguments
|
|  Class Methods:       1. rollDice(int numberOfDice, int sides), returns int
|                       2. resetGame(), no return
|
|  Instance Methods:  
|                       1. getTotalGamesWon(), returns integer
|                       2. getTotalGamesWonComingOut(), returns integer
|                       3. getTotalGamesAfterComingOut(), returns integer
|                       4. getTotalGamesEndedComingOut(), returns integer
|                       5. getRolls(), returns integer
|                       6. playGame(), no return
|                      
|
| *==========================================================================*/

package craps;

public class Craps 
{
    
    private final int NATURAL = 7;
    private final int YOLEVEN = 11;
    private final int SNAKE_EYES = 2;
    private final int ACE_DEUCE = 3;
    private final int BOX_CARS = 12;
    
    private final int TWO_DICE = 2;
    private final int SIX_SIDES = 6;
    
    private int rolls;
    private int totalGamesWon;
    private int totalGamesWonComingOut;
    private int totalGamesAfterComingOut;
    private int totalGamesEndedComingOut;
    
    
    public Craps()
    {
        
        rolls = 0;
        totalGamesWon = 0;
        totalGamesWonComingOut = 0;
        totalGamesAfterComingOut = 0;
        totalGamesEndedComingOut = 0;
        
        
    }
    
    /**
     * Method: playGame()
     * 
     * Purpose: This method is the bulk of the Craps class, it is essentially
     *          the simulation of the craps game. It helps track the amount of
     *          games won, total games coming out, and amount of rolls. 
     *          It starts off by summing two dice rolls which become the point
     *          and checking if the roll is a natural or yo-leven and if so,
     *          the games is won. However, if the roll is a snake eyes, ace 
     *          deuce, or box cars then the game is lost. Otherwise, the game
     *          continues and rolling continues until the roll is neither the
     *          point and neither 7 in which it is checked if it matches the
     *          point. If so, the game is won, otherwise, it is lost.    * 
     * 
     * 
     */
    public void playGame()
    {
        
        int valueOfRoll;
        int point;
        int sum;
        
        resetGame();
        sum = rollDice(TWO_DICE, SIX_SIDES);
        rolls++;
        point = sum;
        
        if (point == NATURAL || point == YOLEVEN)
        {
            
            totalGamesWon++;
            totalGamesWonComingOut++;
            totalGamesEndedComingOut++;
            
        }
        else if (point != SNAKE_EYES && point != ACE_DEUCE && point != BOX_CARS)
        {
            
            do
            {
                
                sum = rollDice(TWO_DICE, SIX_SIDES);
                rolls++;
                valueOfRoll = sum;
                
            } while (valueOfRoll != point && valueOfRoll != NATURAL);
            
            if (valueOfRoll == point)
            {
               
               totalGamesWon++;
               totalGamesAfterComingOut++;
                
            }
            else
            {

                totalGamesAfterComingOut++;
                
            }
            
        }
        else
        {
            
            totalGamesEndedComingOut++;
            
        }
        
    }
    
    /**
     * Method: rollDice(numberOfDice, sides)
     * 
     * Purpose: The method simulates the rolling of two dice and returns the 
     *          sum of each die roll. This method uses the Die class to create
     *          a Die object to simulate a die roll.
     * 
     * @param numberOfDice The number of dice to roll.
     * @param sides The number of sides for each die.
     * @return The sum of the result of both die rolls.
     */
    private int rollDice(int numberOfDice, int sides)
    {
        
        Die die = new Die();
        int sum = 0;
        int counter = 0;
        
        do
        {
            
            sum += die.rollDie(sides);
            counter++;
            
        } while (counter < numberOfDice);
        
        return sum;
        
    }
    
    /**
     * Method: resetGame()
     * 
     * Purpose: Resets the values of rolls, totalGamesWon, 
     *          totalGamesWonComingOut, totalGamesAfterComingOut, and 
     *          totalGamesEndedComingOut back to 0. This is done to ensure
     *          that playGame is collecting data only for one game each.
     * 
     */
    private void resetGame()
    {
        
        rolls = 0;
        totalGamesWon = 0;
        totalGamesWonComingOut = 0;
        totalGamesAfterComingOut = 0;
        totalGamesEndedComingOut = 0;
        
    }
    
    /**
     * Method: getTotalGamesWon()
     * 
     * Purpose: Returns the total games won.
     * 
     * @return Total games won
     */
    public int getTotalGamesWon()
    {
        
        return totalGamesWon;
        
    }
    
    /**
     * Method: getTOtalGamesWonComingOut()
     * 
     * Purpose: Returns the total number of games won on the coming out roll.
     * 
     * @return Total games won on the coming out roll
     */
    public int getTotalGamesWonComingOut()
    {
        
        return totalGamesWonComingOut;
        
    }
    
    /**
     * Method: getTotalGamesAfterComingOut()
     * 
     * Purpose: Returns the total number of games that occurred after the 
     *          coming out roll.
     * 
     * @return Total games after coming out roll
     */
    public int getTotalGamesAfterComingOut()
    {
        
        return totalGamesAfterComingOut;
        
    }
    
    /**
     * Method: getTOtalGamesEndedComingOut()
     * 
     * Purpose: Returns the total number of games that ended in the coming out
     *          roll.
     * 
     * @return Total games that ended on coming out roll
     */
    public int getTotalGamesEndedComingOut()
    {
        
        return totalGamesEndedComingOut;
        
    }
    
    /**
     * Method getRolls()
     * 
     * Purpose: Returns the total rolls made in one game.
     * 
     * @return Total rolls of a game
     */
    public int getRolls()
    {
        
        return rolls;
        
    }
    
}
