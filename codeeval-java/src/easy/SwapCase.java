package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by cedric on 5/9/2016.
 */
public class SwapCase {

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                char[] chars = line.toCharArray();
                StringBuilder result = new StringBuilder();
                for (Character s : chars) {
                    if (Character.isUpperCase(s)) {
                        result.append(s.toString().toLowerCase());
                    } else {
                        result.append(s.toString().toUpperCase());
                    }
                }
                System.out.println(result.toString());
            }
        }
    }

}
