/*==========================================================================
|   Source code:  PrimeSequence.java
|
|         Class:  PrimeSequence
|
|        Author:  
|    Student ID:  
|    Assignment:  Program #5 - Prime Sequence
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
|      Language:  Java
|   Compile/Run: 

| 	javac PrimeSequence.java
|	
|
|        Purpose:  The class serves to go through a sequence of numbers and 
                   determines which ones are prime. When the next() method
                   is called, it increments number and returns a prime number
                   if it passes the check in isPrime() otherwise it returns 0.
|
|  Inherits From:  None
|
|     Interfaces:  PrimeSequence implements the Sequence interface

                   Sequence.java interface must be in the same directory of 
                   source files.
|
|  +-----------------------------------------------------------------------
|
|      Constants:  None
|
| +------------------------------------------------------------------------
|
|   Constructors:  
                   PrimeSequence()
                   PrimeSequence(int inputNumber)
|
|  Class Methods:  private isPrime(int number), returns boolean
|
|  Instance Methods:  public next(), returns int
|
|  *==========================================================================*/


package sequencedemo;

public class PrimeSequence implements Sequence 
{
    
    private int number;
    
    public PrimeSequence()
    {
        
        this.number = 1;
        
    }
    
    public PrimeSequence(int inputNumber)
    {
        
        this.number = inputNumber;
        
    }
    
    /**
     * Method: next()
     * 
     * Purpose: The method increments number and checks if it is prime by 
     *          calling isPrime(number), if it is then the number is returned, 
     *          otherwise 0 is returned.
     * 
     * @return Either the prime number or 0
     */
    public int next()
    {
       
        number++;
        
        if (isPrime(number))
        {
            
            return number;
            
        }
        else
        {
            
            return 0;
            
        }
        
    }//End method
    
    /**
     * Method: isPrime(int number)
     * 
     * Purpose: The method returns whether the passed value is a prime number
     *          or not. This algorithm is similar to the implementation of the 
     *          AKS primality test: 
     *          https://en.wikipedia.org/wiki/AKS_primality_test
     * 
     *          However, this specific algorithm was acquired by a user on 
     *          StackOverflow, named Saurabh Kumar, via the following link:
     *          https://stackoverflow.com/a/44016357
     * 
     * @param number The value to be checked for primality
     * @return True if the value is prime, false otherwise.
     */
    private boolean isPrime(int number)
    {
        
        if (number <= 1)
        {
            
            return false;
            
        }
        
        if (number <= 3)
        {
            
            return true;
            
        }
        
        if (number % 2 == 0 || number % 3 == 0)
        {
            
            return false;
            
        }
        
        for (int i = 5; i * i <= number; i = i + 6)
        {
            
            if (number % i == 0 || number % (i + 2) == 0)
            {
                
                return false;
                
            }
            
        }
        
        return true;
        
    }//End method
    
    
}
