package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/1/2016.
 */
public class EvenNumber {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                int i = Integer.parseInt(line);

                if (i % 2 == 0) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }

}
