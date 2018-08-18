/*==========================================================================
|   Source code:  BetterRectangle.java
|
|         Class: BetterRectangle 
|
|        Author:  
|    Student ID:  
|    Assignment:  Program #4 - Better Rectangle
|  
|        Course:  COP 3337 (Programming II)
|       Section:  
|    Instructor:    
|      Due Date:  8 March 2018, at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|      Language:  Java
|  Compile/Run: 

| 	javac BetterRectangle.java
|
|
|        Purpose:  The BetterRectangle class servers as a subclass of the 
                   Rectangle class and exists to add more functionality than
                   the Rectangle class already provides. These include
                   getArea(), getPerimeter(), getSlope(), getMidpoint(), and
                   scaleBy(). Methods for comparison include equals(), 
                   congruent(), equivalent(), similar(), and concentric().
|
|  Inherits From:  java.awt.Rectangle
|
|     Interfaces:  N/A
|
|  +-----------------------------------------------------------------------
|
|      Constants:  Point origin is a constant whose coordinate is set to (0, 0)
                   as it serves as the origin point to be set as the location
                   for a rectangle.
|
| +------------------------------------------------------------------------
|
|   Constructors:  
                   1. BetterRectangle()
                   2. BetterRectangle(int width, int height)
                   3. BetterRectangle(int x, int y, int width, int height)
                   4. BetterRectangle(BetterRectangle rectangle)
|
|  Class Methods:  
|
|  Instance Methods: 
                      1. equals(BetterRectangle rectangle) returns boolean
                      2. toString() returns String
                      3. getArea() returns int
                      4. getPerimeter() returns int
                      5. getSlope() returns float
                      6. getMidpoint() returns Point
                      7. congruent(BetterRectangle rectangle) returns boolean
                      8. equivalent(BetterRectangle rectangle) returns boolean
                      9. similar(BetterRectangle rectangle) returns boolean
                     10. concentric(BetterRectangle rectangle) returns boolean
                     11. scaleBy(int scale) returns boolean
|
|  *==========================================================================*/



package brecttester;

import java.awt.Point;

public class BetterRectangle extends java.awt.Rectangle
        
{
    
    final Point origin = new Point(0, 0);
    
    public BetterRectangle()
    {
        
       setLocation(origin);
       setSize(1, 1);
        
    }
    
    public BetterRectangle(int width, int height)
    {
        
       setLocation(origin);
       setSize(width, height);
        
    }
    
    public BetterRectangle(int x, int y, int width, int height)
    {
         
        setLocation(x, y);
        setSize(width, height);
        
    }
    
    public BetterRectangle(BetterRectangle rectangle)
    {
        
        setLocation(rectangle.getLocation());
        setSize((int)rectangle.getWidth(), (int)rectangle.getHeight());
        
    }
    
    /**
     * Method: equals(BetterRectangle rectangle
     * 
     * Purpose: The method compares various characteristics of two objects.
     *          It compares if they share the same x and y coordinate for the
     *          "anchor", it compares the widths and the height, the areas, 
     *          the perimeters, the slopes, and the midpoints. If they all
     *          turn out to be equal then the method returns true.
     * 
     * @param rectangle The BetterRectangle object that is compared with.
     * @return Returns true if characteristics are true, false otherwise
     */
    public boolean equals(BetterRectangle rectangle)
    {
        
        return ((int)rectangle.getX() == (int)getX())
                && ((int)rectangle.getY() == (int)getY())
                && ((int)rectangle.getWidth() == (int)getWidth())
                && ((int)rectangle.getHeight() == (int)getHeight())
                && (rectangle.getArea() == getArea())
                && (rectangle.getPerimeter() == getPerimeter())
                && (rectangle.getSlope() == getSlope())
                && (rectangle.getMidpoint().equals(getMidpoint()));
        
    }
    
    /**
     * Method: toString()
     * 
     * Purpose: The method serves to print out the relevant characteristics
     *          of the object which include: the x and y coordinates of the
     *          "anchor", the width and height, the perimeter, the slope, and
     *          the midpoint of the object.
     * 
     * @return String with object characteristics
     */
    @Override
    public String toString()
    {
        
        return "BetterRectangle[x=" + (int)getX() + ", y=" + (int)getY() 
                + ", width=" + (int)getWidth() + ", height=" + (int)getHeight() 
                + ", area=" + getArea() + ", perimeter=" + getPerimeter() 
                + ", slope=" + getSlope() + ", mid-point=" 
                + getMidpoint().toString() + "]";
        
    }
    
    /**
     * Method: getArea()
     * 
     * Purpose: The method gets the area of the rectangle by multiplying the 
     *          width and the height of the rectangle.
     * 
     * @return The product of the width and height 
     */
    public int getArea()
    {
        
        double area = getWidth() * getHeight();
        
        return (int)area;
        
    }
    
    /**
     * Method: getPerimeter()
     * 
     * Purpose: The method gets the perimeter of the rectangle by adding the 
     *          width and height and multiplying the sum by 2. 
     *          
     *          The perimeter formula is as follows:
     *          
     *          P = (width + height) * 2
     * 
     * @return The result of perimeter calculation
     */
    public int getPerimeter()
    {
        
        double perimeter = (getWidth() + getHeight()) * 2;
        
        return (int)perimeter;
        
    }
    
    /**
     * Method: getSlope()
     * 
     * Purpose: The method gets the slope of the rectangle by dividing the 
     *          height by the width.
     * 
     * @return The result of dividing height and width
     */
    public float getSlope()
    {
        
        double slope = getHeight() / getWidth();
        
        return (float)slope;
        
    }
    
    /**
     * Method: getMidpoint()
     * 
     * Purpose: The method gets the midpoint by adding the x coordinate of
     *          the rectangle and the center x; it repeats this for the y
     *          coordinate and center y. These two values, midpointX and
     *          midpointY, are rounded up to the nearest integer using 
     *          Math.ceil(). A Point object is created using these values and
     *          returned.
     * 
     * @return The midpoint as a Point
     */    
    public Point getMidpoint()
    {
        
        double midpointX = Math.ceil(getX() + getCenterX());
        double midpointY = Math.ceil(getY() + getCenterY());
        
        Point midpoint = new Point((int)midpointX, (int)midpointY);
        
        return midpoint;
        
    }
    
    /**
     * Method: congruent(BetterRectangle rectangle)
     * 
     * Purpose: The method determines if the two objects compared are congruent
     *          by determining if the sum of both objects' widths and heights
     *          are within a certain threshold to be considered congruent. The
     *          DELTA constant is used to determine if the values are close
     *          enough to be considered equal.
     * 
     * @param rectangle The object to be determined if congruent
     * @return True if they are congruent, false otherwise.
     */
    public boolean congruent(BetterRectangle rectangle)
    {
        
        final double DELTA = 0.001;
        
        return Math.abs(rectangle.getWidth() + rectangle.getHeight()) - 
                (getWidth() + getHeight()) < DELTA;
        
    }
    
    /**
     * Method: equivalent(BetterRectangle rectangle)
     * 
     * Purpose: The method determines if the two rectangles compared are 
     *          equivalent. It does this by comparing the perimeters of each
     *          to see if they are equal.
     * 
     * @param rectangle The object to be determined if equivalent
     * @return True if perimeters are equal, false otherwise.
     */
    public boolean equivalent(BetterRectangle rectangle)
    {
        
        return rectangle.getPerimeter() == getPerimeter();
        
    }
    
    /**
     * Method: similar(BetterRectangle rectangle)
     * 
     * Purpose: The method determines if the two rectangles are similar 
     *          by comparing the areas of the two.
     * 
     * @param rectangle The rectangle to be determined if similar
     * @return True if areas are equal, false otherwise.
     */
    public boolean similar(BetterRectangle rectangle)
    {
        
        return rectangle.getArea() == getArea();
        
    }
    
    /**
     * Method: concentric(BetterRectangle rectangle)
     * 
     * Purpose: The method determines if two rectangles have the same midpoint
     *          by comparing the midpoints of the two.
     * 
     * @param rectangle The rectangle to be determined if concentric
     * @return True if the midpoints are equal, false otherwise.
     */
    public boolean concentric(BetterRectangle rectangle)
    {
        
        return rectangle.getMidpoint().equals(getMidpoint()); 
        
    }
    
    /**
     * Method: scaleBy(int scale)
     * 
     * Purpose: The method scales the width and the height of the rectangle by
     *          the passed value but only if that value is greater than 0. If
     *          it is, the scale is successful and returns true, otherwise 
     *          it is unsuccessful and returns false.
     * 
     * @param scale The factor which the rectangle will be scaled by
     * @return True if scale is successful, false otherwise.
     */
    public boolean scaleBy(int scale)
    {
        
        final int BOUNDARY = 0;
        
        if(scale > BOUNDARY)
        {
            
            setSize((int)(scale * getWidth()), (int)(scale * getHeight()));
            return true;
            
        }
        else
        {
            
            return false;
            
        }
        
    }
    
}
