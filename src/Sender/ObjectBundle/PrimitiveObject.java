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
        
        System.out.println("\t Enter integer: ");
        integerField = scan.nextInt();
    }
    
    // To be used for unit testing
    public PrimitiveObject(int testInteger) {
        integerField = testInteger;
    }
    
}
