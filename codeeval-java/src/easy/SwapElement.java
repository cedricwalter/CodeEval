package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by cedric on 5/1/2016.
 */
public class SwapElement {


    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] split = line.split(":");
                List<String> elements = new ArrayList<>(Arrays.asList(split[0].split(" ")));
                String[] orders = split[1].split(",");
                for (String order : orders) {
                    String[] positions = order.trim().split("-");
                    Collections.swap(elements, Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
                }
                System.out.println(elements.toString().replaceAll(",", "").replace("[", "").replace("]", ""));
            }
        }
    }

}
