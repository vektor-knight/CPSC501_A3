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
public class PrimitiveObject {
    
    // Necessary primitive instance variables
    public int integerField;
    public double doubleField;
    public char charField;
    
    public PrimitiveObject() {
    
    }
    
    // To be used for unit testing
    public PrimitiveObject(int testInteger) {
        integerField = testInteger;
        charField = 'x'; 
    }
    
}
