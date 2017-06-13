package hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cedric on 5/9/2016.
 */
public class CapitalizeWords {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] words = line.split(" ");
                List<String> list = new ArrayList<>();
                for (String word : words) {
                    list.add(word.substring(0, 1).toUpperCase() + word.substring(1));
                }
                System.out.println(String.join(" ", list));
            }
        }
    }

}
