/*=============================================================================  
|   Source code:  TriangleTester.java
|        Author:  Nathan Pabon 
|    Student ID:  5909334  
|    Assignment:  Program # 2 Triangle
|  
|        Course:  COP 3337 (Intermediate Programming) 
|       Section:  U02 
|    Instructor:  William Feild  
|      Due Date:  7 February 2018, at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|     Language:  Java 
|  Compile/Run:
|
| 	javac TriangleTester.java  Triangle.java
|	java TriangleTester
| 
|  +---------------------------------------------------------------------------- 
|  
|  Description:  The purpose of the program is to create a triangle with the 
|                input of three points and print out the resulting triangle's 
|                properties.
|                  
|        Input:  The user inputs integers or decimals for each coordinate of
|                each point of the triangle and the program takes them in as
|                doubles.
|  
|       Output:  The program will output the coordinates of each point entered 
|                by the user, the length of each side, the angles, the 
|                perimeter, the area, whether it is equilateral, and whether it
|                is a right triangle. Coordinates, side lengths, perimeter, and
|                area are all formatted to be displayed in four decimal places.
|                Degrees are displayed as whole numbers.
|  
|      Process:  The program goes through the following steps:
|                
|                1. The user inputs the coordinates for each point and is 
|                   prompted to imput a valid coordinate if they do not do so.
|
|                 2. Each pair of coordinates is passed as an argument to the
|                   setPoint methods belonging to the Triangle class.
|
|                3. The coordinates, side lengths, angles, perimeter, area, and
|                   triangle type are all printed out once the user finishes
|                   inputting all of the coordinates. The printing is done in 
|                   the form of static methods. This information is acquired 
|                   through methods belonging to the Triangle class.
|  
|   Required Features Not Included:  
|                
|                All of the required features are in the program.
|  
|   Known Bugs:  There are no known bugs in the code.  

    Note:
            A more detailed explanation of how the methods function can be found
            in the documentation of the Triangle class.
|  *==========================================================================*/
package triangle;

/* Scanner class imported for user input. */
import java.util.Scanner;

public class TriangleTester 
{
    
    private static Triangle triangle = new Triangle();

    public static void main(String[] args) 
    {

        int counter = 1;
        double xCoordinate;
        double yCoordinate;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the x, y coordinates of three points in"
                + "this order: (x1, y1), (x2, y2), (x3, y3)");
        
        System.out.println("Separate each coordinate with a <return>: ");
        
        do
        {
            
            while(!scan.hasNextDouble())
            {
            
                System.out.println("Please enter a valid integer or decimal.");
                scan.next();
            
            }
            
            xCoordinate = scan.nextDouble();
            
            while(!scan.hasNextDouble())
            {
                
                System.out.println("Please enter a valid integer or decimal.");
                scan.next();
                
            }
            
            yCoordinate = scan.nextDouble();
            
            if (counter == 1)
            {
                
                triangle.setPoint1(xCoordinate, yCoordinate);
                
            }
            else if (counter == 2)
            {
                
                triangle.setPoint2(xCoordinate, yCoordinate);
                
            }
            else
            {
                
                triangle.setPoint3(xCoordinate, yCoordinate);
                
            }
        
            counter++;
        
        }while(counter <= 3);
        
        printCoordinates();
        
        printSideLengths();
        
        printAngles();
        
        printPerimeter();
        
        printArea();
        
        printIsEquilateral();
        
        printIsRightAngled();
   
    }//End main
    
    /**
     * Method: printCoordinates()
     * 
     * Purpose: The purpose of the method is to print the coordinates
     *          of each point of the triangle with the points formatted
     *          to display in four decimal places.
     * 
     * @return none
     */
    private static void printCoordinates()
    {
        
        System.out.printf("Point 1 Coordinates: (%.4f, %.4f)\n", 
                triangle.getPoint1X(), triangle.getPoint1Y());
        
        System.out.printf("Point 2 Coordinates: (%.4f, %.4f)\n", 
                triangle.getPoint2X(), triangle.getPoint2Y());
        
        System.out.printf("Point 3 Coordinates: (%.4f, %.4f)\n\n", 
                triangle.getPoint3X(), triangle.getPoint3Y());
    }
    
    /**
     * Method: printSideLengths()
     * 
     * Purpose: The purpose of this method is to print the lengths of each
     *          individual side of the triangle on its own line formatted
     *          to display up to four decimal places.
     * 
     * @return none
     */
    private static void printSideLengths()
    {
       
        System.out.printf("Side 1 Length: %.4f meters\n", triangle.getSide1());
        System.out.printf("Side 2 Length: %.4f meters\n", triangle.getSide2());
        System.out.printf("Side 3 Length: %.4f meters\n\n", triangle.getSide3());
        
    }
    
    /**
     * Method: printAngles()
     * 
     * Purpose: Prints each angle of the triangle formatted to display as 
     *          whole numbers.
     * 
     * @return none
     */
    private static void printAngles()
    {
        
        System.out.printf("Angle 1: %.0f degrees\n", triangle.getAngle1());
        System.out.printf("Angle 2: %.0f degrees\n", triangle.getAngle2());
        System.out.printf("Angle 3: %.0f degrees\n\n", triangle.getAngle3());
        
    }
    
    /**
     * Method: printPerimeter()
     * 
     * Purpose: Prints the perimeter of the triangle formatted to four 
     *          decimal places.
     * 
     * @return none
     */
    private static void printPerimeter()
    {
        
        System.out.printf("The perimeter of the triangle is %.4f meters\n", 
                triangle.getPerimeter());
        
    }
    
    /**
     * Method: printArea()
     * 
     * Purpose: Prints the area of the triangle formatted to four decimal 
     *          places.
     * 
     * @return none
     */
    private static void printArea()
    {
        
        System.out.printf("The area of the triangle is %.4f square meters\n", 
                triangle.getArea());
        
    }
    
    /**
     * Method: printIsEquilateral()
     * 
     * Purpose: Prints whether or not the triangle created is an equilateral 
     *          triangle.
     * 
     * @return none
     */
    private static void printIsEquilateral()
    {
        
        System.out.println("The triangle is equilateral: " 
                + triangle.isEquilateral());
        
    }
    
    /**
     * Method: printIsRightAngled()
     * 
     * Purpose: Prints whether or not the triangle created is a right angled
     *          triangle.
     * 
     * @return none
     */
    private static void printIsRightAngled()
    {
        
       System.out.println("The triangle is right-angled: " 
                + triangle.isRightAngled()); 
        
    }
    
}//End class
