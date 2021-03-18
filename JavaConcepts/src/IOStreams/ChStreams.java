package IOStreams;

import java.io.*;

//Implemented Character Streams

public class ChStreams {
    public static void main(String[] args) throws IOException {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("src/bytfile.txt");
            out = new FileWriter("bytfileout.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}

