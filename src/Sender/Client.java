package Sender;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Referenced from:
 * https://github.com/Scraniel/CPSC501-ReflectiveSerializer/blob/master/ReflectiveSerializer/src/sender/Client.java
 * General process adapted from Zahra Sahaf's TA code.
 * @author vektor
 */
public class Client {
    
    public static void sendDoc(String IP, int port, byte[] data) throws IOException {
        try {
            Socket sock = new Socket(IP, port);
            try (OutputStream output = sock.getOutputStream()) {
                output.write(data, 0, data.length);
                output.flush();
            }
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
}
