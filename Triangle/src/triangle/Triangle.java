/*============================================================================
|   Source code: Triangle.java
|
|         Class: Triangle 
|
|        Author:  
|    Student ID:  
|    Assignment:  Program #2 - Triangle
|  
|        Course:  COP 3337 (Programming II)
|       Section:  
|    Instructor:    
|      Due Date:  6 February 2018, at the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|        Language:  Java
|  Compile/Run: 
|
|	Assuming you only want to compile the Triangle class
|
| 	javac Triangle.java
|	java Triangle
|
|	Otherwise
|	
|	javac TriangleTester.java Triangle.java
|	java Triangle
|
|        Purpose:  The purpose of this class is to retain information regarding
|                  the points the user inputs from a tester to create a 
|                  triangle. This information is then used to perform several
|                  tasks should the specific method be called. Tasks performed 
|                  by the methods include setting points, getting point 
|                  coordinates, getting side lengths, getting angles, getting
|                  perimeter, getting area, and determining whether it is an 
|                  equilateral triangle, right triangle, or neither.
|
|  Inherits From:  None
|
|     Interfaces:  None
|
| +-----------------------------------------------------------------------
|
|      Constants:  The only constants in the class are initialized only when
|                  isRightAngled() method is called as it is the only method
|                  which requires the usage of the constants. R
|                  IGHT_ANGLE_DEGREE is the degree at which the right 
|                  angle is defined, specifically 90 degrees. The DELTA constant
|                  is used to determine the value of an angle is close enough
|                  to be considered a whole numbered angle, specifically used to
|                  determine if an angle is close enough to be considered 90
|                  degrees even if it may be 89.9999 degrees.
|
| +-----------------------------------------------------------------------
|
|   Constructors:  Triangle(), no arguments
|
|  Class Methods:  None
|
|  Instance Methods:  
|                       1. setPoint1(double x, double y), no return
|                       2. setPoint2(double x, double y), no return
|                       3. setPoint3(double x, double y), no return
|                       4. getPoint1X(), returns double
|                       5. getPoint1Y(), returns double
|                       6. getPoint2X(), returns double
|                       7. getPoint2Y(), returns double
|                       8. getPoint3X(), returns double
|                       9. getPoint3Y(), returns double
|                      10. getSide1(), returns double
|                      11. getSide2(), returns double
|                      12. getSide3(), returns double
|                      13. getAngle1(), returns double
|                      14. getAngle2(), returns double
|                      15. getAngle3(), returns double
|                      16. getPerimeter(), returns double
|                      17. getArea(), returns double
|                      18. isEquilateral, returns boolean
|                      19. isRightAngled, returns boolean
|
| +-----------------------------------------------------------------------
|   
|   Formulas Used:
|                   The methods getAngle1(), getAngle2(), and getAngle3()
|                   all utilize the Law of Cosines to determine the angles.
|
|                   cos(C) = (a^2 + b^2 − c^2) / (2*a*b)
|                   cos(A) = (b^2 + c^2 − a^2) / (2*b*c)
|                   cos(B) = (c^2 + a^2 − b^2) / (2*c*a) 
|
|                   The 2s in the calculations are PART of the formula and thus
|                   they are not magic numbers.
|
|                   The getArea() method utilizes Heron's Formula for 
|                   calculating the area of a triangle.
|                    
|                   s = (a + b + c) / 2 <--- Half of the perimeter
|                   
|                   A = square root[s * (s - a) * (s - b) * (s - c)]
|                   
|                   The 2 used to get the half of the perimeter is not a magic
|                   number as it is a part of Heron's Formula.
|
| *==========================================================================*/

package triangle;

/* Point2D class imported */
import java.awt.geom.Point2D;

public class Triangle 
{
    
    private Point2D point1 = new Point2D.Double();
    private Point2D point2 = new Point2D.Double();
    private Point2D point3 = new Point2D.Double();
    
    
    public Triangle()
    {
        
        point1.setLocation(-1, -1);
        point2.setLocation(-1, -1);
        point3.setLocation(-1, -1);
        
    }
    
    /**
     * Method: setPoint1(x, y)
     * 
     * Purpose: Sets the coordinates for point 1.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public void setPoint1(double x, double y)
    {
        
        point1.setLocation(x, y);
        
    }
    
    /**
     * Method: setPoint2(x, y)
     * 
     * Purpose: Sets the coordinates for point 2.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public void setPoint2(double x, double y)
    {
        
        point2.setLocation(x, y);
        
    }
    
    /**
     * Method: setPoint3(x, y)
     * 
     * Purpose: Sets the coordinates for point 3.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public void setPoint3(double x, double y)
    {
        
        point3.setLocation(x, y);
        
    }
    
    /**
     * Method: getPoint1X()
     * 
     * Purpose: Returns the x coordinate for point 1.
     * 
     * @return X coordinate
     */
    public double getPoint1X()
    {    
        
        return point1.getX();
        
    }
    
    /**
     * Method: getPoint1Y()
     * 
     * Purpose: Returns the y coordinate for point 1.
     * 
     * @return Y coordinate
     */
    public double getPoint1Y()
    {
        
        return point1.getY();
        
    }
    
    /**
     * Method: getPoint2X()
     * 
     * Purpose: Returns the x coordinate for point 2.
     * 
     * @return X coordinate
     */
    public double getPoint2X()
    {
        
        return point2.getX();
        
    }
    
    /**
     * Method: getPoint2Y()
     * 
     * Purpose: Returns the y coordinate for point 2.
     * 
     * @return Y coordinate
     */
    public double getPoint2Y()
    {
        
        return point2.getY();
        
    }
    
    /**
     * Method: getPoint3X()
     * 
     * Purpose: Returns the x coordinate for point 3.
     * 
     * @return X coordinate
     */
    public double getPoint3X()
    {
        
        return point3.getX();
        
    }
    
    /**
     * Method: getPoint3Y()
     * 
     * Purpose: Returns the y coordinate for point 3.
     * 
     * @return Y coordinate
     */
    public double getPoint3Y()
    {
        
        return point3.getY();
        
    }
    
    /**
     * Method: getSide1()
     * 
     * Purpose: Uses distance() method from Point2D class to find the length
     *          of side 1.
     * 
     * @return length of side 1
     */
    public double getSide1()
    {
        
        double side1 = point2.distance(point3);
        
        return side1;
        
    }
    
    /**
     * Method: getSide2()
     * 
     * Purpose: Uses distance() method from Point2D class to find the length
     *          of side 2.
     * 
     * @return length of side 2
     */
    public double getSide2()
    {
        
        double side2 = point1.distance(point3);
        
        return side2;
        
    }
    
    /**
     * Method: getSide3()
     * 
     * Purpose: Uses distance() method from Point2D class to find the length
     *          of side 3.
     * 
     * @return length of side 3
     */
    public double getSide3()
    {
        
        double side3 = point1.distance(point2);
        
        return side3;
        
    }
    
    /**
     * Method: getAngle1()
     * 
     * Purpose: Gets angle 1 by utilizing the Law of Cosines formula for angle 1 
     *          and then converting the radians to degrees.
     *				
     *          cos(A) = (b^2 + c^2 − a^2) / (2*b*c) 
     *
     *          The 2s in the calculations are PART of the formula and thus
     *          they are not magic numbers.
     *
     *		Source: 
     *		https://www.mathsisfun.com/algebra/trig-solving-sss-triangles.html
     * 
     * @return angle 1 in degrees
     */
    public double getAngle1()
    {
        
        /*This utilizes the Law of Cosines formulas documented above 
		to find the angle. */
		
        double angle1 = Math.acos( (Math.pow(getSide2(), 2) 
                + Math.pow(getSide3(), 2) - Math.pow(getSide1(), 2)) /
                (2 * getSide2() * getSide3()) );
        
        double angle1ToDegrees = Math.toDegrees(angle1);
        
        return angle1ToDegrees;
        
    }
    
    /**
     * Method: getAngle2()
     * 
     * Purpose: Gets angle 1 by utilizing the Law of Cosines formula 
     *           for angle 2 and then converting the radians to degrees.
     *				
     *          cos(B) = (c^2 + a^2 − b^2) / (2*c*a) 
     *
     *          The 2s in the calculations are PART of the formula and thus
     *          they are not magic numbers.
     *
     *		Source:
     *		https://www.mathsisfun.com/algebra/trig-solving-sss-triangles.html
     * 
     * @return angle 2 in degrees
     */
    public double getAngle2()
    {
        
        /* This utilizes the Law of Cosines to find the angle */
        double angle2 = Math.acos( (Math.pow(getSide3(), 2) 
                + Math.pow(getSide1(), 2) - Math.pow(getSide2(), 2)) /
                (2 * getSide3() * getSide1()) );
        
        double angle2ToDegrees = Math.toDegrees(angle2);
        
        return angle2ToDegrees;
                
    }
    
    /**
     * Method: getAngle3()
     * 
     * Purpose: Gets angle 1 by utilizing the Law of Cosines formula
     *          for angle 1 and then converting the radians to degrees.
     *				
     *	        cos(C) = (a^2 + b^2 − c^2) / (2*a*b)            
     *
     *          The 2s in the calculations are PART of the formula and thus
     *          they are not magic numbers.
     *
     *		Source:
     *		https://www.mathsisfun.com/algebra/trig-solving-sss-triangles.html
     *
     * @return angle 3 in degrees
     */
    public double getAngle3()
    {
        
        /* This utilizes the Law of Cosines to find the angle */
        double angle3 = Math.acos( (Math.pow(getSide1(), 2) 
                + Math.pow(getSide2(), 2) - Math.pow(getSide3(), 2)) /
                (2 * getSide1() * getSide2()) );
        
        double angle3ToDegrees = Math.toDegrees(angle3);
        
        return angle3ToDegrees;
        
    }
    
    /**
     * Method: getPerimeter()
     * 
     * Purpose: Adds the lengths of all sides of the triangle and gets the 
     *          perimeter. It does this using the following formula:
     *
     *          Perimeter = SideA + SideB + SideC
     * 
     * @return perimeter of the triangle
     */
    public double getPerimeter()
    {
        
        return getSide1() + getSide2() + getSide3();
        
    }
    
    /**
     * Method: getArea()
     * 
     * Purpose: Gets the area of the triangle by utilizing Heron's Formula:
     *			
     *          This gets half of the perimeter.
     *          s = (a + b + c) / 2 
     *         
     *          A = square root[s * (s - a) * (s - b) * (s - c)]
     *              
     *          The 2 used to get the half of the perimeter is not a magic
     *          number as it is a part of Heron's Formula.
     * 
     * @return area of the triangle.
     */
    public double getArea()
    {
        /* Gets the half of the perimeter by dividing by 2. */
        double halfOfPerimeter = getPerimeter() / 2;
        
        /* This utilizes Heron's Formula to find the area. */
        double area = Math.sqrt( halfOfPerimeter * (halfOfPerimeter 
                - getSide1()) * (halfOfPerimeter - getSide2()) * 
                (halfOfPerimeter - getSide3()) );
        
        return area;
        
    }
    
    /**
     * Method: isEquilateral()
     * 
     * Purpose: Determines whether all the sides of the triangle are equal or
     *          not.
     * 
     * @return true if equal sides, false otherwise
     */
    public boolean isEquilateral()
    {
               
        return getSide1() == getSide2() && getSide1() == getSide3();
        
    }
    
    /**
     * Method: isRightAngled()
     * 
     * Purpose: Determines if the triangle is right angled by comparing the 
     *          absolute value of the angle and 90 degrees and checking if
     *          it's less than the DELTA (in the even that the angle is not 
     *          exactly 90 but is close enough to be considered 90.)
     *          
     *          If any angles are found to be right angles, it is determined to
     *          be a right angled triangle.
     * 
     * @return true if right angled, false otherwise
     */
    public boolean isRightAngled()
    {
        final double RIGHT_ANGLE_DEGREE = 90.0;
        final double DELTA = 0.00001;
        
        return Math.abs(getAngle1() - RIGHT_ANGLE_DEGREE) < DELTA || 
               Math.abs(getAngle2() - RIGHT_ANGLE_DEGREE) < DELTA ||
               Math.abs(getAngle3() - RIGHT_ANGLE_DEGREE) < DELTA;
        
    }   
    
}//End class
