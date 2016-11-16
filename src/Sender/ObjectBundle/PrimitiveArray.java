/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender.ObjectBundle;

/**
 *
 * @author vektor
 */
public class PrimitiveArray {
    
    // While it is possible to scale this up so that the user can 
    // set values in an array for any primitives whatsoever, I 
    // begin with one instance of an int array as a proof-of-concept.
    public int[] x;
    
    public PrimitiveArray() {
        
    }
    
    public PrimitiveArray(boolean flag) {
        int[] i = null;
        x = i;
        
        
    }
    
}
