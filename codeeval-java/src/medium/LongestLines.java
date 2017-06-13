package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by cedric on 5/1/2016.
 */
public class LongestLines {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        int i = 0;

        NavigableMap<Integer, String> map = new TreeMap<Integer, String>();

        int nbLines = 0;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                if (i == 0) {
                    nbLines = Integer.parseInt(line);
                    i++;
                } else {
                    map.put(line.length(), line);
                }
            }
        }

        for (int j = 0; j < nbLines; j++) {
            System.out.println(map.pollLastEntry().getValue());
        }
    }

}
