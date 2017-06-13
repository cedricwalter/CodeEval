package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class LetterPercentageRatio {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String l;
        while ((l = in.readLine()) != null) {
            if (l.length() > 0) {
                int u = 0;
                for (int i = 0; i < l.length(); i++) {
                    int a = (int) l.charAt(i);
                    if (a >= 65 && a <= 90) {
                        u++;
                    }
                }
                double p = u * 100.0 / l.length();
                System.out.println(String.format("lowercase: %.2f uppercase: %.2f", 100 - p, p));
            }
        }
    }

}
