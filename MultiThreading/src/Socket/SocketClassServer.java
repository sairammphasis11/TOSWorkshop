package Socket;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClassServer {

    public static void main(String[] args) {
        ServerSocket server;
        try {
           server= new ServerSocket(7357);
           while(true) {
               Socket clientSocket = server.accept();
               OutputStream os = clientSocket.getOutputStream();
               PrintWriter wr = new PrintWriter(os);
               wr.write("HELOO FROM SERVER");
               wr.flush();
               System.out.println("Connected");
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
