package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/1/2016.
 */
public class BitPositions {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] split = line.split(",");
                Integer number = Integer.parseInt(split[0]);

                int p1 = Integer.parseInt(split[1]);
                int p2 = Integer.parseInt(split[2]);

                if (((number >> (p1 - 1)) & 1) == ((number >> (p2 - 1)) & 1)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }

}
