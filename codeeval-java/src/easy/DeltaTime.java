package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cedric on 5/9/2016.
 */
public class DeltaTime {

    static DateFormat date = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] times = line.split(" ");

                Date date1 = date.parse(times[0]);
                Date date2 = date.parse(times[1]);

                long durationInMillis = date1.getTime() - date2.getTime();

                int seconds = (int) (durationInMillis / 1000) % 60;
                int minutes = (int) ((durationInMillis / (1000 * 60)) % 60);
                int hours = (int) ((durationInMillis / (1000 * 60 * 60)));

                System.out.printf("%02d:%02d:%02d%n", Math.abs(hours), Math.abs(minutes), Math.abs(seconds));
            }
        }
    }

}
