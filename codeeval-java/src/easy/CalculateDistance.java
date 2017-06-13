package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class CalculateDistance {


    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] coordinates = line.split("\\) \\(");
                String[] point1 = coordinates[0].replace("(", "").replace(")", "").split(",\\ ");
                String[] point2 = coordinates[1].replace("(", "").replace(")", "").split(",\\ ");

                double x1 = Double.parseDouble(point1[0]);
                double x2 = Double.parseDouble(point2[0]);
                double y1 = Double.parseDouble(point1[1]);
                double y2 = Double.parseDouble(point2[1]);

                System.out.println((long) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
            }
        }
    }
}
