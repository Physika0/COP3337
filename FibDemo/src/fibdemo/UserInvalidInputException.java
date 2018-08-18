/*==========================================================================
|   Source code:  UserInvalidInputException.java
|
|         Class: UserInvalidInputException 
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
| 	javac UserInvalidInputException.java
|	
|
|        Purpose:  This class serves as a means to indicate that the user
                   may have entered and invalid input. It is used to handle
                   exceptions of this kind.
|
|  Inherits From:  IllegalArgumentException
|
|     Interfaces:  None
|
|  +-----------------------------------------------------------------------
|
|      Constants:  None
|
| +------------------------------------------------------------------------
|
|   Constructors:  UserInvalidInputException()
|
|  Class Methods:  None
|
|  Instance Methods:  UserInvalidInputException(String message)
|
|  *==========================================================================*/

package fibdemo;

public class UserInvalidInputException extends IllegalArgumentException
{
    
    public UserInvalidInputException ()
    {
        
    }
    
    public UserInvalidInputException(String message)
    {
        
        super(message);
        
    }
    
}
