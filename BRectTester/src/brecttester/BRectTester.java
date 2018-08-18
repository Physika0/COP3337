/*=============================================================================  
|   Source code:  BRectTester.java
|        Author:   
|    Student ID:   
|    Assignment:  Program # 4 - Better Rectangle
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
|     Language:  Java 
|  Compile/Run: 
| 	javac BRectTester.java  BetterRectangle.java
|	java BRectTester
| 
|  +---------------------------------------------------------------------------
|  
|  Description:  The purpose of the program is to test a class that is a sub
|                subclass of the Rectangle class. The subclass is called
|                BetterRectangle and has various method added to it that 
|                the regular Rectangle class does not have. Such methods 
|                include: getArea(), getPerimeter(), getSlope(), getMidpoint,
|                congruent(), equivalent(), similar(), concentric(), and 
|                scaleBy().
|                Constructors were also added to serve different purposes.
|
|                The tester tests this class by providing a test case where
|                four BetterRectangle objects are created. The objects are 
|                either modified or compared with one another to determine if
|                the BetterRectangle class is functioning properly.
|                  
|        Input:  No input is required by the user.  
|  
|       Output:  Output includes printing of the objects using an overrided
|                toString() method. The area, perimeter, slope, and midpoint of
|                bRectA is printed. Comparisons between bRectB and bRectC are 
|                made which include: equality, congruence, similarity, 
|                equivalence, and concentricity. bRectD is also outputted with
|                scale() method tests.
|  
|      Process:  The program goes through the following steps:
|                
|                1. Four BetterRectangle objects are created.
|                 
|                2. The contents of the four BetterRectangle objects are 
|                   printed.
|
|                3. area(), perimeter(), slope(), midpoint(), methods are 
|                   tested against bRectA. Results are printed.
|
|                4. equals(), congruent(), equivalent(), similar(), concentric()
|                   are tested against bRectB and bRectC. Results are printed.
|
|                5. scale() is tested against bRectD. Results are printed.
|  
|   Required Features Not Included:  
|                
|                Decimal outputs aren't formatted to two decimal places. Not 
|                sure if it will be an issue as it is not explicitly stated 
|                in the specifications but it is shown in the sample output.
|                Although the sample output isn't consistent with decimal place
|                formatting.
|  
|   Known Bugs:  There are no known bugs in the code.  
|  *==========================================================================*/

package brecttester;

public class BRectTester 
{

    public static void main(String[] args)
    {
        
        BetterRectangle bRectA = new BetterRectangle(3,4);
        BetterRectangle bRectB = new BetterRectangle(bRectA);
        BetterRectangle bRectC = new BetterRectangle(1,1,4,3);
        BetterRectangle bRectD = new BetterRectangle();
        
        System.out.println("A: " + bRectA.toString());
        System.out.println("B: " + bRectB.toString());
        System.out.println("C: " + bRectC.toString());
        System.out.println("D: " + bRectD.toString() + "\n");
        
        System.out.println("Accessor methods being executed for "
                + "Rectangle A...");
        System.out.println("A: BetterRectangle " + bRectA.toString());
        System.out.println("Area:      " + bRectA.getArea());
        System.out.println("Perimeter: " + bRectA.getPerimeter());
        System.out.println("Slope:     " + bRectA.getSlope());
        System.out.println("MidPoint:  (" + (int)bRectA.getMidpoint().getX()
                + ", " + (int)bRectA.getMidpoint().getY() + ")\n");
        
        System.out.println("Utility methods being executed for Rectangle B"
                + "and C...");
        System.out.println("B: " + bRectB.toString());
        System.out.println("C: " + bRectC.toString());
        System.out.println("Equals? " + bRectB.equals(bRectC));
        System.out.println("Congruent? " + bRectB.congruent(bRectC));
        System.out.println("Equivalent? " + bRectB.equivalent(bRectC));
        System.out.println("Similar? " + bRectB.similar(bRectC));
        System.out.println("Concentric? " + bRectB.concentric(bRectC) + "\n");
        
        System.out.println("Mutator methods being executed for Rectangle D...");
        System.out.println("D: " + bRectD.toString());
        System.out.println("Scale by 3? " + bRectD.scaleBy(3));
        System.out.println("Scale by -3? " + bRectD.scaleBy(-3));
        System.out.println("D: " + bRectD.toString());
        
    }
    
}
