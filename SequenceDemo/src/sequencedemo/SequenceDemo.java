/*=============================================================================  
|   Source code:  SequenceDemo.java
|        Author:  
|    Student ID:    
|    Assignment:  Program # 5 Prime Sequence
|  
|        Course:  COP 3337 (Programming II)  
|       Section:  
|    Instructor:    
|      Due Date:  3 April 2018, at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|     Language:  Java 
|  Compile/Run:  
| 	javac SequenceDemo.java  PrimeSequence.java Sequence.java

|	java SequenceDemo [starting value] [amount of primes requested]

        The two command-line arguments must be integers greater than 0.
        Sequence.java interface must be in the same directory as source files.
| 
|  +---------------------------------------------------------------------------
|  
|  Description:  The purpose of the the program is to generate prime numbers
                 and provide an analysis by printing the prime numbers generated
                 and a histogram showing how many times the last digit of a
                 prime number has occurred.
|                  
|        Input:  The input is received through command-line arguments when the 
                 program is compiled in a terminal. The first value entered is
                 an integer greater than 0 that serves as the starting number
                 and the second value entered is also greater than 0 and serves
                 as the amount of prime numbers to be generated. The values are
                 integers.
|  
|       Output:  The sequence of prime numbers generated is printed in a table
                 format and the amount of occurrences of the last digit is 
                 displayed in a histogram right after.
|  
|      Process:  
                 1. Before the program runs, the user must input two 
                    command-line arguments that are integers and are greater 
                    than 0. The first value is the starting number while the 
                    second value is the amount of primes to be generated.

                 2. Once the program runs these inputs are taken and validated
                    in a validate() method before they are used to prevent the 
                    program from accepting invalid input.

                 3. Once the values are determined to be valid, a PrimeSequence
                    object is constructed with the starting number passed and
                    the array to contain prime numbers is set to have a size 
                    of the amount of prime numbers to be generated.

                 4. To generate prime numbers, the generatePrimeNumbers() method
                    is called which fills the fills the prime number array until
                    it reaches the amount of primes requested.

                 5. The prime numbers are then displayed by calling the 
                    displayPrimeNumbers() method which displays the prime 
                    numbers generated in a relatively box-like shape.

                 6. Finally, the histogram is displayed by calling the 
                    displayHistogram() method which fills a counter array that
                    keeps track of the occurrences of the last digit in the 
                    prime numbers generated.
|  
|   Required Features Not Included:  
|                I was unable to include the proper scaling of the histogram.
                 I could not figure out way to display the histogram in a way
                 that would prevent it from displaying an excessive amount of
                 '*' if a large amount of prime numbers were requested.
|  
|   Known Bugs:  Not sure if this constitutes as a bug, but the prime numbers
                 table doesn't actually look the way it was intended as in the
                 case when three digit prime numbers begin to appear.
|  *==========================================================================*/

package sequencedemo;

public class SequenceDemo 
{
    public static final int LAST_DIGITS = 10;
    
    public static int startNumber = 1;
    public static int primesToBeSequenced = 1;
    public static int[] primeArray;
    public static int[] counterArray = new int[LAST_DIGITS];
    public static PrimeSequence primeSeq;
    
    public static void main(String[] args) 
    {
        
        validate(args);        
        
        primeArray = new int[primesToBeSequenced];
        primeSeq = new PrimeSequence(startNumber);
        
        generatePrimeNumbers();
                        
        displayPrimeNumbers();
        
        displayHistogram();
        
    }
    //End main
    
    /**
     * Method: displayPrimeNumbers()
     * 
     * Purpose: The method displays the prime numbers generated in a box-like
     *          table by rounding up the square root of the requested amount of
     *          primes and then iterating through the array of primes checking
     *          when to make a new line which happens if the rounded square root
     *          value can evenly divide the index it's currently in.
     * 
     */
    public static void displayPrimeNumbers()
    {
        
        System.out.println("Printing a sequence of prime numbers: ");
        int rowsAndColumns = (int) Math.ceil(Math.sqrt(primesToBeSequenced));
        
        for(int index = 0; index < primeArray.length; index++)
        {
            
            if(index != 0 && index % rowsAndColumns == 0)
            {
                
                System.out.print(primeArray[index] + " ");
                System.out.println("");
                
            }
            else if (index % rowsAndColumns == 0)
            {
                
                System.out.print(primeArray[index] + " ");
                        
            }
            else
            {
                
                System.out.print(primeArray[index] + " ");
                
            }
            
        }
        
        System.out.println("\n");
        
    }//End method
    
    /**
     * Method: displayHistogram()
     * 
     * Purpose: The method iterates through the primeArray, gets the modulus 10
     *          of the number at the current index (this gets the last digit) 
     *          and increments the counterArray at the index of the last digit
     *          value found.
     * 
     *          The counterArray is then iterated through using nested for loop
     *          to place an '*' for each occurrence of the last digit.
     * 
     */
    public static void displayHistogram()
    {
        
        for(int index = 0; index < primeArray.length; index++)
        {
            
            int lastDigit = primeArray[index] % 10;
            counterArray[lastDigit]++;
            
        }
        
        System.out.println("Last Digit Histogram: ");
        for(int index = 0; index < counterArray.length; index++)
        {
            
            System.out.print("[" + index + "]");
            
            for(int counterIndex = 0; counterIndex < 
                    counterArray[index]; counterIndex++)
            {
                
                System.out.print('*');
                
            }
            
            System.out.println("");
            
        }
        
    }//End method
    
    /**
     * Method: validate(String[] args)
     * 
     * Purpose: The method uses a series of nested if statements (I am aware
     *          that this doesn't exactly look nice) to check if the command
     *          line arguments, contained in the passed array, have valid 
     *          integers. A valid input must be an integer, anything that 
     *          contains a letter or period is not accepted, and must be greater
     *          than 0, this is determined after it passes the integer check so
     *          that Integer.parseInt() doesn't end up attempting to parse a 
     *          character/word or decimal number.
     * 
     * @param args The command-line arguments inputed by the user to be checked
     *             for validity.
     */
    public static void validate(String[] args)
    {
        
        if(Character.isDigit(args[0].charAt(0)))
        {
              
              if(args[0].contains("."))
              {
                  
                  System.out.println("Invalid number format");
                  System.exit(1);
                  
              }
              else
              {
                  
                  if(Integer.parseInt(args[0]) > 0)
                  {
                      
                      startNumber = Integer.parseInt(args[0]);
                      
                  }
                  else
                  {
                      
                      System.out.println("Invalid integer");
                      System.out.println("Input must be greater than 0");
                      System.exit(1);
                      
                  }
                  
              }      
                
        }
        else
        {
                
            System.out.println("Invalid number format");
            System.exit(1);
                
        }
        
        if(Character.isDigit(args[1].charAt(0)))
        {
            
            if(args[1].contains("."))
              {
                  
                  System.out.println("Invalid number format");
                  System.exit(1);
                  
              }
              else
              {
                  
                  if(Integer.parseInt(args[1]) > 0)
                  {
                      
                      primesToBeSequenced = Integer.parseInt(args[1]);
                      
                  }
                  else
                  {
                      
                      System.out.println("Invalid integer");
                      System.out.println("Input must be greater than 0");
                      System.exit(1);
                      
                  }
                  
              }
   
        }
        else
        {
            
            System.out.println("Invalid number format");
            System.exit(1);
            
        }
        
    }//End method
    
    /**
     * Method: generatePrimeNumbers()
     * 
     * Purpose: The method generates prime numbers by calling the next() method
     *          with the object primeSeq and sets it to the primeNumber value.
     *          This value is checked if it is not equal to 0 and proceeds to 
     *          enter it at the index of the current count in primeArray. It
     *          also checks if count is equal to the primes to be sequenced in
     *          which the while loop stops if this is the case. 
     * 
     *          A while loop was used because not every loop requires the count
     *          to increment.
     * 
     */
    public static void generatePrimeNumbers()
    {
        
        boolean done = false;
        int count = 0;
        
        while(!done)
        {
            
            int primeNumber = primeSeq.next();
            
            if(primeNumber != 0)
            {
                
                primeArray[count] = primeNumber;
                count++;
                
            }
            
            if(count == primesToBeSequenced)
            {
                
                done = true;
                
            }
            
        }
        
    }//End method
    
}
