package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/1/2016.
 */
public class MthToLastElement {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] values = line.split(" ");
                int elementLength = values.length - 1;
                int position = Integer.parseInt(values[elementLength]);
                if (position <= elementLength && position != 0) {
                    System.out.println(values[elementLength - position]);
                }
            }
        }
    }

}
