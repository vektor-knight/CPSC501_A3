package Receiver;

import Inspectors.Inspector;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * General Server algorithm adapted from: 
 * https://github.com/Scraniel/CPSC501-ReflectiveSerializer/blob/master/ReflectiveSerializer/src/reciever/Server.java
 * with refactorings and persistent port scanning. Above solution crashes since server socket closes
 * outside of try-block.
 * Also referred to Zahra Sahaf's TA code.
 * @author vektor
 */
public class Server {
    
    public static void main(String[] args) throws IOException, JDOMException, Exception {
        
        boolean listen = true;
        SAXBuilder builder = new SAXBuilder();
        Scanner userInput = new Scanner(System.in);
       
        int port = 6666;
        ServerSocket s = new ServerSocket(port);
        
        while (listen) {
            System.out.println("Scanning port: " + port);
            try (Socket sock = s.accept()) {
                System.out.println("Connection to client made. Reading JDOM.");
                InputStream i = sock.getInputStream();
                Document doc = builder.build(i);
                System.out.println("JDOM read. Deserializing now.");
                Object o = Deserializer.deserialize(doc);
                System.out.println("Object deserialized. Inspecting to confirm.");
                Inspector inspection = new Inspector();
                inspection.inspect(o, false);
            }
            userInput.close();
        }
            
    }
}
