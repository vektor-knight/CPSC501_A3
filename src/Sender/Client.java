/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Referenced from:
 * https://github.com/Scraniel/CPSC501-ReflectiveSerializer/blob/master/ReflectiveSerializer/src/sender/Client.java
 * @author vektor
 */
public class Client {
    
    public static void sendDoc(String IP, int port, byte[] data) throws IOException {
        try {
            Socket sock = new Socket(IP, port);
            OutputStream output = sock.getOutputStream();
            output.write(data, 0, data.length);
            output.flush();
            output.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
