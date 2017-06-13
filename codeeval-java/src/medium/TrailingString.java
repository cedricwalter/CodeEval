package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/9/2016.
 */
public class TrailingString {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] todo = line.split(",");
                String phrase = todo[0];
                String string = todo[1];

                if (phrase.endsWith(string)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }

}
