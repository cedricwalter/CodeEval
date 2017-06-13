package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/1/2016.
 */
public class SplitTheNumber {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] split = line.split(" ");

                String number = split[0];
                String order = split[1];
                String[] sign = order.split("-");
                boolean add = false;
                if (sign.length != 2) {
                    sign = order.split("\\+");
                    add = true;
                }

                Integer a = Integer.valueOf(number.substring(0, sign[0].length()));
                Integer b = Integer.valueOf(number.substring(sign[0].length(), number.length()));

                System.out.println(add ? a + b : a - b);
            }
        }
    }

}
