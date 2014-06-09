/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilities;

import java.text.DecimalFormat;

/**
 *
 * @author Renliw
 */
public class GetPercentage {
    public static String getPercent(int numerator, int denominator){
        DecimalFormat df2 = new DecimalFormat("00.00");
        double d = ((double)numerator/(double)denominator)*100;
        
        return df2.format(d);
    }
    
     public static String decimalToString(double d){
        DecimalFormat df2 = new DecimalFormat("00.00");
        
        return df2.format(d);
    }
}
