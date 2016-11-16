/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

/**
 *
 * @author vektor
 */
public class ObjectCreator {
    public static void main(String[] args) {
		System.out.print("Serialization menu. Choose one to create: \n"
				+ "1. Simple int-type primitive object \n"
				+ "2. Object containing references to other objects, including circular ones \n"
				+ "3. Array of primitives (int-type) \n"
				+ "4. Array of object references \n"
				+ "5. Java Collection object \n"
				+ "Selection:  ");
    // Programming Plan:
        // Since the Serializer was created first in this branch, the 
    // implementation of ObjectCreator will finally allow for
    // unit testing to presume, because now Objects will be available to test
    // whether they are being serialized into JDOM format correctly.
    // In terms of what kinds of Objects can be created, we follow the 
    // specifications as follows:
        // User can select from the following:
    // 1. Simple object containing only primitive instance variables.
    
    // 2. Object containing references to other objects.
    // 3. Object containing array of primitives.
    // 4. Object containing array of object references.
    // 5. Object using an instance of a Collection class from the
    // Java library.
    
    // In this implementation, users will be prompted to select from any
    // of the five options above. The most common way to do this would be
    // to use a series of switch statements. Rather than doing this, which
    // would result in a long class, I will immediately replace the conditional
    // (the switch statements) with a series of polymorphisms, and use 
    // this class to bundle those polymorphic subclasses.
    }
}
