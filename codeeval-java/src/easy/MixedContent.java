package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by cedric on 5/1/2016.
 */
public class MixedContent {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                LinkedList digits = new LinkedList<>();
                LinkedList words = new LinkedList<>();
                String[] split = line.split(",");
                for (String s : split) {
                    if (s.matches("^[0-9]*")) {
                        digits.add(s);
                    } else {
                        words.add(s);
                    }
                }
                String separator = "";
                if (digits.size() > 0 && words.size() > 0)
                    separator = "|";

                System.out.println((words.toString().replace("[", "").replace("]", "") + separator + digits.toString().replace("[", "").replace("]", "")).replaceAll(" ", ""));
            }
        }
    }

}
