/*=============================================================================  
|   Source code:  FibDemo.java
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
|     Language:  Java 
|  Compile/Run:
| 	javac FibDemo.java FibSequence.java LoopFibSequence.java 
              FastFibSequence.java UserInvalidInputException.java Stopwatch.java

|	java FibDemo [Input file] [Output file]

        Ex. java FibDemo inFile.txt outFile.txt
        
        Input file and output file must be in the same directory as the source
        code files. The file names must include their file extensions 
        (i.e. inFile.txt, inFile.rtf, inFile.NFO).

        Input file must have two values which include the starting number
        (between 1 and 10) and the amount of fibonacci numbers to display
        (between 1 and 39); these two values must be separated by a new line.
        
| 
|  +---------------------------------------------------------------------------
|  
|  Description:  The program takes in arguments which include the input file, 
                 which contains the starting number and amount of fibonacci
                 numbers to display, and the output file. It calculates the
                 same fibonacci numbers using three different algorithms: 
                 recursive, iterative, and fast. These are then displayed in
                 table format with times displayed under each one.
                 
|                  
|        Input:  One of the arguments is the input file which contains the 
                 starting value for fibonacci calculations and the number of
                 fibonacci numbers to display with a range of 1 - 10 and
                 1 - 39, respectively. These values are separated with a 
                 new line. 
|  
|       Output:  The output is done in an output file which contains a table
                 and time recording of the fibonacci numbers calculated for
                 each algorithm.
|  
|      Process:  
                1. First it checks if the user has entered the correct amount
                   of arguments otherwise it throws an exception.

                2. It checks if there is any content in the input file and if
                   not then it throws an exception, otherwise it parses the 
                   contents as integers for the starting value and number of 
                   fibonacci numbers.

                3. It then checks if the starting value and number of fibonacci
                   numbers to display is within their respective ranges, if not,
                   then an exception is thrown and the program terminates.
                 
                4. The program then prints the fibonacci numbers calculated
                   and their timing for each algorithm onto a output file.
|  
|   Required Features Not Included:  
|                All of the required features are in the program. 
|  
|   Known Bugs:  
                There does not appear to be any bugs in the program.
                
|  *==========================================================================*/
package fibdemo;

/*File imported to construct object which allows Scanner to read from file.*/
import java.io.File;
/*FileNotFoundException imported to handle exceptions in the event that a file
  is not present.*/
import java.io.FileNotFoundException;
/*PrintWriter imported to write output to text file.*/
import java.io.PrintWriter;
/*Scanner imported to read input from file.*/
import java.util.Scanner;

public class FibDemo
{
    
    static StopWatch timer = new StopWatch();
    
    static PrintWriter out;
  
    static int startingNumber = 1;
    static int amountOfFibNum = 39;
    
    final static int FIRST_ARGUMENT = 0;
    final static int LAST_ARGUMENT = 1;
    final static int MIN_STARTING_NUMBER = 1;
    final static int MAX_STARTING_NUMBER = 10;
    final static int MIN_AMOUNT_OF_FIB = 1;
    final static int MAX_AMOUNT_OF_FIB = 39;
    final static int REQUIRED_ARGUMENTS = 2;

    public static void main(String[] args)
    {
        
        try
        {
            
            if(args.length != REQUIRED_ARGUMENTS)
            {
                
                throw new UserInvalidInputException("Invalid number of "
                        + "arguments.");
                
            }
            
            String inputFileName = args[FIRST_ARGUMENT];
            String outputFileName = args[LAST_ARGUMENT];
            
            File inputFile = new File(inputFileName);
            Scanner in = new Scanner(inputFile);
            out = new PrintWriter(outputFileName);
            
            if(!(in.hasNextLine()))
            {
                
                throw new UserInvalidInputException("Input file is empty.");
                
            }
            else
            {
                
                startingNumber = Integer.parseInt(in.nextLine().trim());
                amountOfFibNum = Integer.parseInt(in.nextLine().trim());
                
            }
            
            
            if(startingNumber < MIN_STARTING_NUMBER ||
                    startingNumber > MAX_STARTING_NUMBER)
            {
                
                throw new UserInvalidInputException("Starting number [" +
                        startingNumber + "] is not within " +
                        MIN_STARTING_NUMBER + " and " + MAX_STARTING_NUMBER + 
                        " range.");
                
            }
            else if(amountOfFibNum < MIN_AMOUNT_OF_FIB || 
                    amountOfFibNum > MAX_AMOUNT_OF_FIB)
            {
                
                throw new UserInvalidInputException("Amount of "
                        + "fibonacci numbers to"
                        + " display [" + amountOfFibNum + "} is not within "
                        + MIN_AMOUNT_OF_FIB + " and " + MAX_AMOUNT_OF_FIB 
                        + " range.");
                
            }
            
            displayFibResults();
            displayLoopFibResults();
            displayFastFibResults();
            
            in.close();
            out.close();
              
        }
        catch(FileNotFoundException | UserInvalidInputException exception)
        {
            
            System.out.println(exception.getMessage());
            System.exit(1);
            
        }catch(NumberFormatException exception)
        {
           
           System.out.println("The arguments are not integers.");
           System.exit(1);
            
        }
        
    }
    
    /**
     * Method: displayFibResults()
     * 
     * Purpose: The method displays the results of the fibonacci calculations
     *          with the recursive algorithm. 
     * 
     *          It outputs the fibonacci numbers in table format and in the 
     *          event there is arithmetic overflow, the overflowed numbers are
     *          replaced with asterisks.
     * 
     *          The time it takes for the calculation is recorded in nanoseconds
     *          and in order to convert it to microseconds the value is divided
     *          by 1000.
     * 
     */
    public static void displayFibResults()
    {
        
        FibSequence fib = new FibSequence(startingNumber);
        
        int rowsAndColumns = (int) Math.ceil(Math.sqrt(amountOfFibNum));
        
        out.println("Normal Recursive");
        
        timer.reset();
        timer.start();
        for(int count = 1; count <= amountOfFibNum; count++)
        {
            
            try
            {
                
                int fibNumber = fib.next();

                if(count != 0 && count % rowsAndColumns == 0)
                {

                    out.printf("%10d ", fibNumber);
                    out.println("");

                }
                else if (count % rowsAndColumns == 0)
                {

                    out.printf("%10d ", fibNumber);

                }
                else
                {

                    out.printf("%10d ", fibNumber);

                }
                
            }
            catch(ArithmeticException exception)
            {
                
                String overflowPlaceholder = "**********";
                out.printf("%10s ", overflowPlaceholder);
                
            }
            
        }
        timer.stop();
        
        long elapsedTime = timer.getElapsedTime() / 1000;
        out.println("\nTime to compute: " + elapsedTime + " microseconds\n");
        
    }
    
    /**
     * Method: displayLoopFibResults()
     * 
     * Purpose: The method displays the results of the fibonacci calculations
     *          with the iterative algorithm. 
     * 
     *          It outputs the fibonacci numbers in table format and in the 
     *          event there is arithmetic overflow, the overflowed numbers are
     *          replaced with asterisks.
     * 
     *          The time it takes for the calculation is recorded in nanoseconds
     *          and in order to convert it to microseconds the 
     *          elapsed time value is divided by 1000.
     * 
     */
    public static void displayLoopFibResults()
    {
        
        LoopFibSequence loopFib = new LoopFibSequence(startingNumber);
        
        int rowsAndColumns = (int) Math.ceil(Math.sqrt(amountOfFibNum));
        
        out.println("Iterative - Expected");
        
        timer.reset();
        timer.start();
        for(int count = 1; count <= amountOfFibNum; count++)
        {
            
            try
            {
                
                int fibNumber = loopFib.next();

                if(count != 0 && count % rowsAndColumns == 0)
                {

                    out.printf("%10d ", fibNumber);
                    out.println("");

                }
                else if (count % rowsAndColumns == 0)
                {

                    out.printf("%10d ", fibNumber);

                }
                else
                {

                    out.printf("%10d ", fibNumber);

                }
                
            }
            catch(ArithmeticException exception)
            {
                
                String overflowPlaceholder = "**********";
                out.printf("%10s ", overflowPlaceholder);
                
            }
              
        }
        timer.stop();
        
        long elapsedTime = timer.getElapsedTime() / 1000;
        out.println("\nTime to compute: " + elapsedTime + " microseconds\n");
        
    }
    
    /**
     * Method: displayFastFibResults()
     * 
     * Purpose: The method displays the results of the fibonacci calculations
     *          with the fast recursive algorithm. 
     * 
     *          It outputs the fibonacci numbers in table format and in the 
     *          event there is arithmetic overflow, the overflowed numbers are
     *          replaced with asterisks.
     * 
     *          The time it takes for the calculation is recorded in nanoseconds
     *          and in order to convert it to microseconds the 
     *          elapsed time value is divided by 1000.
     * 
     */
    public static void displayFastFibResults()
    {
        
        FastFibSequence fastFib = new FastFibSequence(startingNumber, 
        amountOfFibNum);
        
        int rowsAndColumns = (int) Math.ceil(Math.sqrt(amountOfFibNum));
        
        out.println("Fast Recursive");
        
        timer.reset();
        timer.start();
        for(int count = 1; count <= amountOfFibNum; count++)
        {
            
            try
            {
                
                int fibNumber = fastFib.next();

                if(count != 0 && count % rowsAndColumns == 0)
                {

                    out.printf("%10d ", fibNumber);
                    out.println("");

                }
                else if (count % rowsAndColumns == 0)
                {

                    out.printf("%10d ", fibNumber);

                }
                else
                {

                    out.printf("%10d ", fibNumber);

                }
                
            }
            catch(ArithmeticException exception)
            {
                
                String overflowPlaceholder = "**********";
                out.printf("%10s ", overflowPlaceholder);
                
            }

        }
        timer.stop();
        
        long elapsedTime = timer.getElapsedTime() / 1000;
        out.println("\nTime to compute: " + elapsedTime + " microseconds\n");
        
    }
    
}
