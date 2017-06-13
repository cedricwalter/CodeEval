package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by cedric on 5/9/2016.
 */
public class RollerCoaster {

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                char[] chars = line.toCharArray();
                int i = 0;
                StringBuilder result = new StringBuilder();
                for (Character singleChar : chars) {
                    String s1 = singleChar.toString();
                    if (s1.matches("^[a-zA-Z]+$")) {
                        if (i++ % 2 == 0) {
                            s1 = s1.toUpperCase();
                        } else {
                            s1 = s1.toLowerCase();
                        }
                    }
                    result.append(s1);
                }
                System.out.println(result.toString());
            }
        }
    }

}
