package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class Testing {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String l;
        while ((l = in.readLine()) != null) {
            String[] sentences = l.split("\\ \\|\\ ");
            String[] leftWords = sentences[0].split(" ");
            String[] rightWords = sentences[1].split(" ");

            int e = 0;
            for (int i = 0; i < Math.min(leftWords.length, rightWords.length); i++) {
                String leftWord = leftWords[i];
                String rightWord = rightWords[i];
                for (int j = 0; j < Math.min(leftWord.length(), rightWord.length()); j++) {
                    if (leftWord.charAt(j) != rightWord.charAt(j))
                        e++;
                }
                e += Math.abs(leftWord.length() - rightWord.length());
            }
            e += Math.abs(leftWords.length - rightWords.length);

            if (e == 0)
                System.out.println("Done");
            else if (e <= 2)
                System.out.println("Low");
            else if (e <= 4)
                System.out.println("Medium");
            else if (e <= 6)
                System.out.println("High");
            else
                System.out.println("Critical");
        }
    }
}
