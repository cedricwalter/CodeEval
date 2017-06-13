package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by cedric on 5/9/2016.
 */
public class StringMask {

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] strings = line.split(" ");

                char[] chars = strings[1].toCharArray();
                int i = 0;
                StringBuilder result = new StringBuilder();
                for (Character s : strings[0].toCharArray()) {
                    if (chars[i++] == '1') {
                        result.append(s.toString().toUpperCase());
                    } else {
                        result.append(s.toString());
                    }
                }
                System.out.println(result.toString());
            }
        }
    }

}