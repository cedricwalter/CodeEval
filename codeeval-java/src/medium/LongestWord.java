package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by cedric on 5/1/2016.
 */
public class LongestWord {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                NavigableMap<Integer, LinkedList<String>> map = new TreeMap<>();
                String[] split = line.split(" ");
                for (String s : split) {
                    LinkedList list = map.get(s.length());
                    if (list == null) {
                        list = new LinkedList();
                    }
                    list.add(s);
                    map.put(s.length(), list);
                }

                System.out.println(map.pollLastEntry().getValue().getFirst());
            }
        }
    }

}
