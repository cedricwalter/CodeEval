package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cedric on 5/9/2016.
 */
public class TimeToEat {

    static DateFormat date = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] times = line.split(" ");

                List<Date> list = new ArrayList<>();
                for (String time : times) {
                    list.add(date.parse(time));
                }

                Stream.of(list)
                        .collect(Collectors.toCollection(LinkedList::new))
                        .descendingIterator()
                        .forEachRemaining(strings -> Stream.of(strings).forEach(adate -> System.out.println(date.format(adate))));

            }
        }
    }

}
