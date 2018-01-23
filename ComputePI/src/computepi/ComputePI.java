/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computepi;

import java.lang.Math;

/**
 *
 * @author npabon11
 */
public class ComputePI {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int FIRST_ITERATION = 1;
        int iterationCount = 0;        
        double numberToBeDividedBy = 1.0;
        double computedValue = 0.0;
        
        final double EXPECTED_VALUE = 3.141593;
        final double DELTA = 0.0000004;
        
        boolean continueToIterate = true;

        while(continueToIterate)
        {            
            
            iterationCount++;
            
            if (iterationCount % 2 == 1)
            {
                
                computedValue += 4 / numberToBeDividedBy;
                
            }
            else
            {
                
                computedValue -= 4 / numberToBeDividedBy;
                
            }
            
            numberToBeDividedBy += 2;
            
            if (iterationCount > FIRST_ITERATION)
            {
                
                if (Math.abs(EXPECTED_VALUE - computedValue) < DELTA)
                {
                    
                    continueToIterate = false;
                    
                }
                
            }
            
            
            
            //FIXME: Printing for testing purposes, DELETE later
            System.out.println(computedValue);
            
        }
        
        
        System.out.println("Expected Value: " + EXPECTED_VALUE);
        System.out.println("Computed Value: " + computedValue);
        System.out.println("Required Iterations: " + iterationCount);
        
    }
    
}
