package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/9/2016.
 */
public class ArmstrongNumbers {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(isArmstrongNumber(Integer.parseInt(line)) ? "True" : "False");
        }
    }

    public static boolean isArmstrongNumber(int n) {
        int sum = 0;
        int counter = n;
        int digits = countDigit(n);
        while (counter > 0) {
            int digit = counter % 10;
            int nthPower = digit;
            for (int i = 1; i < digits; i++) {
                nthPower *= digit;
            }

            sum += nthPower;
            counter /= 10;
        }

        return sum == n;
    }

    static int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

}
