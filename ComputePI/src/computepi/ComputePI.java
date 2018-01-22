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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int DECIMAL_PLACE = 7;
        int iterationCount = 0;
        double numberToBeDividedBy = 1.0;
        double computedValue = 0.0;
        
        final String EXPECTED_VALUE = 
            Double.toString(Math.PI).substring(0, DECIMAL_PLACE);
        
        String computedValueToString;
        
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
            
            computedValueToString = Double.toString(computedValue);
            
            if (iterationCount > 1)
            {
                
                if (computedValueToString.substring(0, DECIMAL_PLACE)
                    .equals(EXPECTED_VALUE))
                {
                
                continueToIterate = false;
                
                }
                
            }
            
            
            
            //FIXME: Printing for testing purposes, DELETE later
            System.out.println(computedValue);
            
        }
        
        //FIXME: Output has the wrong decimal place, should be 4
        System.out.println("Expected Value: " + EXPECTED_VALUE);
        System.out.println("Computed Value: " + computedValue);
        System.out.println("Required Iterations: " + iterationCount);
        
    }
    
}
