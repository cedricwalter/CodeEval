package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cedric on 5/9/2016.
 */
public class StringsAndArrows {

    private static Pattern pattern1 = Pattern.compile(">>-->");
    private static Pattern pattern2 = Pattern.compile("<--<<");

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                Matcher matcher1 = pattern1.matcher(line);
                int count1 = 0;
                int from = 0;
                while (matcher1.find(from)) {
                    count1++;
                    from = matcher1.start() + 1; // non disjoint matches support
                }

                Matcher matcher2 = pattern2.matcher(line);
                int count2 = 0;
                int from2 = 0;
                while (matcher2.find(from2)) {
                    count2++;
                    from2 = matcher2.start() + 1;
                }

                System.out.println(count1 + count2);
            }
        }
    }

}
