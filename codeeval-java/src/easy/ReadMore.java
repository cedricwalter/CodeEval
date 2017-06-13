package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/9/2016.
 */
public class ReadMore {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() <= 55) {
                System.out.println(line);
            } else {
                String substring = line.substring(0, 40);
                if (substring.contains(" ")) {
                    int i = substring.lastIndexOf(" ");
                    substring = substring.substring(0, i);
                }
                System.out.println(substring + "... <Read More>");
            }

        }
    }
}
