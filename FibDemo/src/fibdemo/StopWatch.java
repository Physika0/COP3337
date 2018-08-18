/*==========================================================================
|   Source code:  StopWatch.java
|
|         Class: StopWatch
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
| 	javac StopWatch.java
|	
|
|        Purpose:  The class serves as a means to time processes in programs
                   such as how fast fibonacci numbers are calculated to use
                   for comparisons.
|
|  Inherits From:  None
|
|     Interfaces:  None
|
|  +-----------------------------------------------------------------------
|
|      Constants:  None
|
| +------------------------------------------------------------------------
|
|   Constructors:  StopWatch()
|
|  Class Methods:  None
|
|  Instance Methods:  start(), no return
                      stop(), no return
                      getElapsedTime(), returns long
                      reset(), no return

   Source: This class is a modified version of the one provided in 
           Big Java Early Objects in pages 634 to 635.
|
|  *==========================================================================*/


package fibdemo;

public class StopWatch 
{
    
   private long elapsedTime;
   private long startTime;
   private boolean isRunning;

   public StopWatch()
   {  
      reset();
   }

  /**
   * Method: start()
   * 
   * Purpose: The method starts the stopwatch. Time starts accumulating.
   * 
   */
   public void start()
   {  
      if (isRunning) { return; }
      isRunning = true;
      startTime = System.nanoTime();
   }
   
   /**
    * Method: stop()
    * 
    * Purpose: Stops the stopwatch. Time stops accumulating and is
    *          is added to the elapsed time.
    * 
    */
   public void stop()
   {  
      if (!isRunning) { return; }
      isRunning = false;
      long endTime = System.nanoTime();
      elapsedTime = elapsedTime + endTime - startTime;
   }
   
   /**
    * Method: getElapseTime()
    * 
    * Purpose: Returns the total elapsed time.
    * 
    * @return the total elapsed time
    */
   public long getElapsedTime()
   {  
      if (isRunning) 
      {  
         long endTime = System.nanoTime();
         return elapsedTime + endTime - startTime;
      }
      else
      {
         return elapsedTime;
      }
   }
   
   /**
    * Method: reset()
    * 
    * Purpose: Stops the watch and resets the elapsed time to 0.
    * 
    */
   public void reset()
   {  
      elapsedTime = 0;
      isRunning = false;
   }
    
}
