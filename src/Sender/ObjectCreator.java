package Sender;

import Sender.ObjectBundle.CollectionObject;
import Sender.ObjectBundle.ObjectReferences;
import Sender.ObjectBundle.PrimitiveArray;
import Sender.ObjectBundle.PrimitiveObject;
import Sender.ObjectBundle.ReferenceArray;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Switch polymorphism and factory pattern adapted from:
 * 
 * https://en.wikipedia.org/wiki/Abstract_factory_pattern
 * @author vektor
 */
public class ObjectCreator {
    public static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
		System.out.print("Serialization menu. Choose one to create: \n"
				+ "1. Simple int-type primitive object \n"
				+ "2. Object containing references to other objects, including circular ones \n"
				+ "3. Array of primitives (int-type) \n"
				+ "4. Array of object references \n"
				+ "5. Java Collection object \n"
				+ "Selection:  ");
                
                Object selection = null;
                
                switch(userInput.nextLine().charAt(0)) {
                    case '1':
                        selection = new PrimitiveObject(false);
                        break;
                    case '2':
                        selection = new ObjectReferences(false);
                        break;
                    case '3':
                        selection = new PrimitiveArray(false);
                        break;
                    case '4':
                        selection = new ReferenceArray(false);
                        break;
                    case '5':
                        selection = new CollectionObject(false);
                        break;
                }
                
                // Send the object selection to a Serializer: (ie. ObjectCreator -(object)-> Serializer)
                Document doc = new Serializer().serialize(selection);
                
                // Serialize the document into JDOM format:
                XMLOutputter output = new XMLOutputter();
                output.setFormat(Format.getPrettyFormat());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                try {
                    output.output(doc, stream);
                    output.output(doc, System.out); // Output to terminal
                } catch (IOException e) {
                }
                
                System.out.println("\n Sending JDOM to target machine for deserialization.");
                System.out.print("Enter target IP: ");
                String IP = userInput.nextLine();
                System.out.print("Enter port: ");
                int port = userInput.nextInt();
                
                // Open socket and send bytestream to Server
                Client.sendDoc(IP, port, stream.toByteArray());

                
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
