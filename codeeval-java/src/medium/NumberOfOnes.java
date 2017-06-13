package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/9/2016.
 */
public class NumberOfOnes {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                Integer integer = Integer.valueOf(line);
                String binary = Integer.toBinaryString(integer);
                char[] chars = binary.toCharArray();
                int count = 0;
                for (char aChar : chars) {
                    if (aChar == '1') {
                        count++;
                    }
                }

                System.out.println(count);
            }
        }
    }

}
