package IOStreams;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class BuffStreams {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/bytfile.txt");
            out = new FileOutputStream("bytfileout.txt");
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
