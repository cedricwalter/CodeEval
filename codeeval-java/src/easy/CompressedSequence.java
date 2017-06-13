package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class CompressedSequence {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String l;
        while ((l = in.readLine()) != null) {
            String[] numbers = l.split(" ");
            display(numbers);
        }
    }

    private static void display(String[] numbers) {
        int length = numbers.length;

        if (length == 0) {
            return;
        }
        String currentValue = numbers[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            String newValue = numbers[i];
            if (currentValue.equals(newValue)) {
                count++;
            } else {
                System.out.print(String.format("%s %s ", count, currentValue));
                count = 1;
                currentValue = newValue;
            }
        }
        System.out.println(String.format("%s %s ", count, currentValue));
    }

}
