/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender.ObjectBundle;

import java.util.Scanner;

/**
 * Factory method pattern application from:
 * https://github.com/add-em/ObjectSerializer/blob/master/ObjectSimple.java
 * @author vektor
 */
public class PrimitiveObject {
    
    // Necessary primitive instance variables
    public int integerField;
    public double doubleField;
    public char charField;
    
    public PrimitiveObject() {
    
    }
    
    /**
     * When the flag is set to true in the ObjectCreator, the user
     * will be prompted with this constructor's body of statements.
     * @param flag 
     */
    public PrimitiveObject(boolean flag) {
        System.out.println("Set the object's fields:");
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n Enter integer: ");
        integerField = scan.nextInt();
        
        System.out.println("Enter double: ");
        doubleField = scan.nextDouble();
        
        System.out.println("Enter character: ");
        charField = scan.next().charAt(0);
    }
    
    // To be used for unit testing
    public PrimitiveObject(int testInteger) {
        integerField = testInteger;
        charField = 'x'; 
    }
    
}
