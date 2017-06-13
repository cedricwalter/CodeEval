package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by cedric on 5/9/2016.
 */
public class SetIntersection {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] sets = line.split(";");
                SortedSet<String> set00 = new TreeSet<>(Arrays.asList(sets[0].split(",")));
                set00.retainAll(new TreeSet<>(Arrays.asList(sets[1].split(","))));
                System.out.println(set00.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", ""));
            }
        }
    }

}
