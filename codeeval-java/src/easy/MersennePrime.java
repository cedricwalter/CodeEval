package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by cedric on 5/1/2016.
 */
public class MersennePrime {

    //if we only know 48 as of today i dont write code to calculate it ;-)
    static LinkedList<Integer> mersenne = new LinkedList<>(Arrays.asList(3, 7, 31, 127, 2047));

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                int number = Integer.parseInt(line);

                LinkedList list = new LinkedList<>();
                for (Integer aMersene : mersenne) {
                    if (aMersene < number) {
                        list.add(aMersene);
                    }
                }
                System.out.println(list.toString().replace("[", "").replace("]", ""));
            }
        }
    }

}
