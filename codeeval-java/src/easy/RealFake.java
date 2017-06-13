package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/9/2016.
 */
public class RealFake {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            long total = getSum(line);
            System.out.println(total % 10 == 0 ? "Real" : "Fake");
        }
    }

    private static long getSum(String line) {
        String s = line.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        int length = s.length();

        int sum = 0;
        for (int i = 0; i < length; i = i + 2) {
            sum += Integer.parseInt("" + chars[i]) * 2;
        }

        for (int i = 1; i < length; i = i + 2) {
            sum += Integer.parseInt("" + chars[i]);
        }

        return sum;
    }

}
