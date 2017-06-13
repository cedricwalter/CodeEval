package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Created by cedric on 4/29/2016.
 */
public class uniqueElements {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] values = line.split(",");
                LinkedHashSet<String> strings = new LinkedHashSet<>(Arrays.asList(values));
                System.out.println(strings.toString().replace("[", "").replace("]", "").replace(" ", ""));
            }
        }
    }

}
