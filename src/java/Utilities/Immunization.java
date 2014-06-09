/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilities;

import java.util.ArrayList;

/**
 *
 * @author Renliw
 */
public class Immunization {
    public static int getComplete(ArrayList<Integer> al){
        int largest = al.get(0);
        int smallest = al.get(0);
        
        for(int x = 0; x <al.size(); x++){
            if(al.get(x) > largest){
                largest = al.get(x);
            }
            if(al.get(x) < smallest){
                smallest = al.get(x);
            }
        }
        
        return smallest;
    }
    
    public static int getIncomplete(ArrayList<Integer> al){
        int largest = al.get(0);
        int smallest = al.get(0);
        
        for(int x = 0; x <al.size(); x++){
            if(al.get(x) > largest){
                largest = al.get(x);
            }
            if(al.get(x) < smallest){
                smallest = al.get(x);
            }
        }
        
        return largest-smallest;
    }
}
