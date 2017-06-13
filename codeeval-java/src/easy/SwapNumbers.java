package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class SwapNumbers {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String l;
        while ((l = in.readLine()) != null) {
            String[] words = l.split(" ");
            for (String word : words) {
                String last = word.substring(word.length() - 1);
                String first = word.substring(0, 1);
                if (last.equals(first)) { //optimization
                    System.out.print(word + " ");
                } else {
                    System.out.print(last + word.substring(1, word.length() - 1) + first + " ");
                }
            }
            System.out.println("");
        }
    }
}
