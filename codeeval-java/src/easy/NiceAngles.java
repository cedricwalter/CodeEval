package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class NiceAngles {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                Double angle = Double.parseDouble(line);
                int degree = angle.intValue();
                int minutes = new Double((angle - degree) * 60).intValue();
                int seconds = new Double((angle - degree - (minutes / 60.0)) * 3600).intValue();
                System.out.println(String.format("%s.%02d'%02d\"", degree, minutes, seconds));
            }
        }
    }
}
