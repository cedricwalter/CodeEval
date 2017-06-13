package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class TrickOrTreat {


    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] elements = line.split(",");
                int vampires = Integer.parseInt(elements[0].split(":\\ ")[1]);
                int zombies = Integer.parseInt(elements[1].split(":\\ ")[1]);
                int witches = Integer.parseInt(elements[2].split(":\\ ")[1]);
                int house = Integer.parseInt(elements[3].split(":\\ ")[1]);
                long round = (long) (((vampires * 3 + zombies * 4 + witches * 5) * house) / (vampires + zombies + witches));

                System.out.println(round);
            }
        }
    }

}
