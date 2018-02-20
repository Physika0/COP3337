/*=============================================================================  
|   Source code:  Analyzer.java
|        Author:  
|    Student ID:    
|    Assignment:  Program # 3 - Craps
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
|     Language:  Java 
|  Compile/Run:
|
| 	javac Analyzer.java  Craps.java Die.java
|	java Analyzer
| 
|  +---------------------------------------------------------------------------- 
|  
|  Description:  The purpose of the program is to simulate several games of 
|                Craps, from 1 to 1000000, collect data, and display a 
|                statistical summary of the games played.
|                  
|        Input:  The user inputs the amount of games to be analyzed as an 
|                integer between 1 and 1000000.
|  
|       Output:  The program will output a statistical summary of the Craps 
|                games that were played. This includes total games, total rolls,
|                average rolls, longest game (in rolls), total wins, coming out
|                wins, coming out games, continuing on games, and a summary of
|                game lengths in rolls as a tally.
|  
|      Process:  The program goes through the following steps:
|                
|                1. TUser is prompted to input an integer between 1 and 1000000
|                   for the amount of games to be analyzed. This input is 
|                   validated.
|
|                2. Games are played by calling the playGame() method from the
|                   craps object and data is collected to be analyzed.
|
|                3. Summary of game statistics, win statistics, ending 
|                   statistics, and game lengths in rolls are displayed
|                   as the analysis of the games that were played.
|  
|   Required Features Not Included:  
|                
|                All of the required features are in the program.
|  
|   Known Bugs:  There are no known bugs in the code.  
|
|   Note:
|           A more detailed explanation of how the methods function can be found
|           in the documentation of the Craps class.
|  *==========================================================================*/
package craps;

/*Scanner imported to accept user input for amount of games to analyze. */
import java.util.Scanner;

public class Analyzer 
{
    
    static int totalGames = 0;
    static int totalRolls = 0;
    static int totalGamesWon = 0;
    static int totalGamesWonComingOut = 0;
    static int totalGamesAfterComingOut = 0;
    static int totalGamesEndedComingOut = 0;
    static int longestGameInRolls = 0;
    
    /*21 slots are allocated for the array as there are 21 rolls to be tallied*/
    static int[] gameLengthsInRolls = new int[21];
    
    /*These constants are used in the while loop to prevent the user from 
      entering values smaller than the lower bound or larger than the upper
      bound.*/
    static final int LOWER_BOUND_INPUT = 1;
    static final int UPPER_BOUND_INPUT = 1000000;
        
    static int gamesToAnalyze;
        
    static Craps craps = new Craps();

    public static void main(String[] args) 
    {
        
        Scanner scan = new Scanner(System.in);
        
        do 
        {
            
            System.out.println("Please enter the amount of Craps games to be "
                    + "analyzed, between 1 and 1,000,000:");
        
            while(!scan.hasNextInt())
            {   
            
                System.out.println("Please enter a valid integer.");
                scan.next();
            
            }
            
            gamesToAnalyze = scan.nextInt();
            
        } while(gamesToAnalyze < LOWER_BOUND_INPUT || 
                gamesToAnalyze > UPPER_BOUND_INPUT);
        
        fillGameLengthsArray();
        
        for(int count = 0; count < gamesToAnalyze; count++)
        {
            
            craps.playGame();
            collectData();
            
            if (craps.getRolls() > longestGameInRolls)
            {
                
                longestGameInRolls = craps.getRolls();
                
            }
            
            collectDataForGameLengthsArray();

        }
        
        printGameStatistics();
        printWinStatistics();
        printEndingStatistics();
        printGameLengths();
        
        
    }//End main
    
    /**
     * Method: printGameStatistics()
     * 
     * Purpose: The method displays information for the Summary of Game
     *          Statistics section. This section includes the total games, 
     *          total rolls, average rolls, and longest game in rolls.
     */
    public static void printGameStatistics()
    {
        
        double averageRolls = (double)totalRolls / (double)totalGames;
        
        System.out.println("Summary of Game Statistics");
        System.out.println("Total Games:     " + totalGames);
        System.out.println("Total Rolls:     " + totalRolls);
        System.out.printf("Average Rolls:   %.4f\n", averageRolls);
        //FIXME: Use printf for longest game
        System.out.println("Longest Game:    " + longestGameInRolls);
        System.out.println("");
        
    }//End method
    
    /**
     * Method: printWinStatistics()
     * 
     * Purpose: The method displays information for the Summary of Win 
     *          Statistics section. This section includes the amount of games,
     *          outcome, and expected outcome for total wins, coming out wins,
     *          and coming out games.
     * 
     *          The probabilities used in the constants were determined using
     *          the following resource:
     *          http://mathforum.org/library/drmath/view/70263.html
     */
    public static void printWinStatistics()
    {
        
        double totalWinsOutcome = (double)totalGamesWon / (double)totalGames;
        double comingOutWinsOutcome = (double)totalGamesWonComingOut / 
                (double)totalGamesEndedComingOut;
        double comingOutGamesOutcome = (double)totalGamesEndedComingOut / 
                (double)totalGames;
        
        /* 244/495 was determined to be the expected win probability.*/
        final double EXPECTED_WINS = 244.0 / 495.0;
        /* 2/3 was determined to be the expected coming out wins probability.*/
        final double EXPECTED_WINS_COMING_OUT = 2.0 / 3.0;
        /* 1/3 was determined to be the expected coming out games probability.*/
        final double EXPECTED_GAMES_COMING_OUT = 1.0 / 3.0;
        
        System.out.println("Summary of Win Statistics");
        
        System.out.print("Stat                    ");
        System.out.print("Games           ");
        System.out.print("Outcome         ");
        System.out.print("Expected       \n");
        
        System.out.printf("Total Wins:%18d", totalGamesWon);
        System.out.printf("%18.4f", totalWinsOutcome);
        System.out.printf("%17.4f\n", EXPECTED_WINS);
        
        System.out.printf("Coming Out Wins:%13d", totalGamesWonComingOut);
        System.out.printf("%18.4f", comingOutWinsOutcome);
        System.out.printf("%17.4f\n", EXPECTED_WINS_COMING_OUT);
        
        System.out.printf("Coming Out Games:%12d", totalGamesEndedComingOut);
        System.out.printf("%18.4f", comingOutGamesOutcome);
        System.out.printf("%17.4f\n\n", EXPECTED_GAMES_COMING_OUT);
        
    }//End method
    
    /**
     * Method: printEndingStatistics()
     * 
     * Purpose: The method displays information for the Summary of Ending
     *          Statistics section. This section includes the amount of games,
     *          outcome, and expected out come for continuing on games.
     */
    public static void printEndingStatistics()
    {
        
        double continuingOnGamesOutcome = 
                ((double)totalGames - (double)totalGamesEndedComingOut) 
                / (double)totalGames;
        
        /* 2/3 was determined the be the continuing on games probability.*/
        double EXPECTED_GAMES_CONTINUING = 2.0 / 3.0;
        
        System.out.println("Summary of Ending Statistics");
        
        System.out.print("Stat                    ");
        System.out.print("Games           ");
        System.out.print("Outcome         ");
        System.out.print("Expected       \n");
        
        System.out.printf("Continuing On Games:%9d", totalGamesAfterComingOut);
        System.out.printf("%18.4f", continuingOnGamesOutcome);
        System.out.printf("%17.4f\n\n", EXPECTED_GAMES_CONTINUING);
        
    }//End method
    
    /**
     * Method: printGameLengths()
     * 
     * Purpose: The method displays the Summary of Game Lengths in Rolls 
     *          section. This section tallies the number of games associated
     *          with the amount of rolls for that game.
     * 
     */
    public static void printGameLengths()
    {
        
        System.out.println("Summary of Game Lengths in Rolls");
        System.out.println("Rolls           # of Games");
        
        for(int index = 0; index < gameLengthsInRolls.length; index++)
        {
           /* Reason for the number shift is because index in array starts 
              at 0.*/
           int ROLLS_TEN = 9;
           int ROLLS_TWENTY_ONE = 20;
           
           if(index < ROLLS_TEN)
           {
             
             /* 1 is added to index since the indexes in the array start at
                0 and need to be shifted by 1 in order to display the correct
                rolls value in the table.*/
             System.out.printf((index + 1) + "%25d\n", 
                     gameLengthsInRolls[index]);  
               
           }
           else if(index == ROLLS_TWENTY_ONE)
           {
               
               /* 1 is added to index since the indexes in the array start at
                0 and need to be shifted by 1 in order to display the correct
                rolls value in the table.*/
               System.out.printf((index + 1) + "+%23d\n", 
                     gameLengthsInRolls[index]);
               
           }
           else
           {
               
               /* 1 is added to index since the indexes in the array start at
                0 and need to be shifted by 1 in order to display the correct
                rolls value in the table.*/
               System.out.printf((index + 1) + "%24d\n", 
                     gameLengthsInRolls[index]);
               
           }            
            
        }
        
        System.out.printf("Total%21d\n", totalGames);
        
        
    }
    
    /**
     * Method: fillGameLengthsArray()
     * 
     * Purpose: The method fills the array with 0's to when each individual 
     *          element in the index is incremented, it does not throw a 
     *          null pointer exception.
     */
    public static void fillGameLengthsArray()
    {
        
        for(int index = 0; index < gameLengthsInRolls.length; index++)
        {
            
            gameLengthsInRolls[index] = 0;
            
        }
        
    }
    
    /**
     * Method: collectDataForGameLengthsArray()
     * 
     * Purpose: The method increments elements in the gameLengthsInRolls array
     *          to tally up the number of games associated with the amount of
     *          rolls in the array.
     */
    public static void collectDataForGameLengthsArray()
    {
        
        int MAX_ROLLS_FOR_TALLYING = 21;
        int FINAL_INDEX_IN_ARRAY = 20;
        
        if(craps.getRolls() >= MAX_ROLLS_FOR_TALLYING){
            
            gameLengthsInRolls[FINAL_INDEX_IN_ARRAY]++;
            
        }
        else
        {
            
            /* craps.getRolls() shifted back by 1 to prevent an array index 
               out of bounds exception.*/
            gameLengthsInRolls[craps.getRolls() - 1]++;
            
        }  
        
    }
    
    /**
     * Method: collectData()
     * 
     * Purpose: The method collects the data necessary for analysis. This data
     *          is collected from the craps object and includes total games,
     *          total rolls, total games won, total games won in coming out 
     *          roll, total games after coming out roll, and total games ended
     *          after coming out roll.
     */
    public static void collectData()
    {
        
        totalGames++;
        totalRolls += craps.getRolls();
        totalGamesWon += craps.getTotalGamesWon();
        totalGamesWonComingOut += craps.getTotalGamesWonComingOut();
        totalGamesAfterComingOut += craps.getTotalGamesAfterComingOut();
        totalGamesEndedComingOut += craps.getTotalGamesEndedComingOut();
        
    }
    
}//End class
