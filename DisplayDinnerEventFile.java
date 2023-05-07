import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DisplayDinnerEventFile {

    public static void main(String[] args) {

        try {
            // Point to file path, initialize input stream and reader.
            Path file = Paths.get("eList.txt");
            InputStream input;
            input = Files.newInputStream(file.toAbsolutePath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // String variable that holds our reader object.
            String s;
            s = reader.readLine();

            // While there is data to read, print all lines.
            while (s != null) {
                System.out.println(s);
                s = reader.readLine();
            }

            // Close input when finished reading file.
            input.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}