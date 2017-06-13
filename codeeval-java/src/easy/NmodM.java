package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class NmodM {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] lineArray = line.split(",");
                if (lineArray.length > 0) {
                    int n = Integer.parseInt(lineArray[0]);
                    int m = Integer.parseInt(lineArray[1]);
                    int modulo = n;
                    while (Math.abs(modulo) >= Math.abs(m)) {
                        modulo -= m;
                    }
                    System.out.println(modulo);
                }
            }
        }
    }

}
