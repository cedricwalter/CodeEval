package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cedric on 5/26/2016.
 */
public class BeautifulString {

    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(getMax(line.toLowerCase()));
        }
    }

    private static int getMax(String string) throws Exception {
        List<Integer> integers = new ArrayList<>();
        for (int i = 65, j = 97; i <= 90 && j <= 123; i++, j++) {
            String s = string.replaceAll("[^" + (char) i + (char) j + "]", "");
            s.trim();
            integers.add(s.length());
        }
        int sum = 0;
        Collections.sort(integers);
        for (int i = integers.size() - 1, j = 26; i >= 0 && j >= 1; --i, --j) {
            sum += integers.get(i) * j;
        }
        return sum;
    }


}
