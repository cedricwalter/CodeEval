package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cedric on 5/9/2016.
 */
public class BeatOrBit {

    public static Long decodeGray(long gray) {
        long decoded = 0;
        while (gray != 0) {
            decoded ^= gray;
            gray >>>= 1;
        }
        return decoded;
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] grays = line.split("\\|");

                List<String> list = new ArrayList<>();
                for (String gray : grays) {
                    list.add(decodeGray(Integer.parseInt(gray.trim(), 2)).toString());
                }
                System.out.println(String.join(" | ", list));
            }
        }
    }

}
