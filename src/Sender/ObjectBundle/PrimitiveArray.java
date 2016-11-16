/* 
* Reference:
* https://github.com/add-em/ObjectSerializer/blob/master/ObjectArrayOfPrimitives.java
* this class deals with an object that contains an array of primitives
*/
package Sender.ObjectBundle;

import java.util.Scanner;

public class PrimitiveArray {
    int[] primitiveArray;
    
    public PrimitiveArray() {
        
    }
    
    public PrimitiveArray(boolean constructor) {
        primitiveArray = new int[5];
        Scanner kb = new Scanner(System.in);
        
        for (int i = 0; i < primitiveArray.length; i++)
        {
            System.out.println("Enter an integer: ");
            primitiveArray[i] = kb.nextInt();
        }
    }
}