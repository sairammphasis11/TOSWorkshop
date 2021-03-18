package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClassClient {

    public static void main(String[] args) {

        try {
            Socket socket =new Socket("DESKTOP-ONJ6R2S",7357);
            InputStream stream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            System.out.println(br.readLine());
            br.close();
          //  System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}