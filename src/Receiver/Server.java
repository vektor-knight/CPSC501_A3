/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author vektor
 */
public class Server {
    
    public static void main(String[] args) throws IOException, JDOMException, Exception {
        
        boolean listen = true;
        SAXBuilder builder = new SAXBuilder();
        Scanner userInput = new Scanner(System.in);
        int port = Integer.parseInt(args[0]);
        
        ServerSocket s = new ServerSocket(port);
        
        while (listen) {
            System.out.println("Scanning port: " + port);
            Socket sock = s.accept();
            System.out.println("Connection to client made. Reading JDOM.");
            InputStream i = sock.getInputStream();
            Document doc = builder.build(i);
            System.out.println("JDOM read. Deserializing now.");
            Object o = Deserializer.deserialize(doc);
            System.out.println("Object deserialized. Inspecting to confirm.");
            Inspector inspection = new Inspector();
            inspection.inspect(o, false);
            sock.close();
        }
            
    }
}
