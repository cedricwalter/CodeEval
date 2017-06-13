package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/9/2016.
 */
public class CountingPrimes {

    public static boolean isPrime(int n) {
        int root = (int) Math.sqrt(n);

        for (int i = 2; i <= root; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] primes = line.split(",");
                int n = Integer.parseInt(primes[0]);
                int m = Integer.parseInt(primes[1]);

                int currentNumber = n;
                int primeFound = 0;
                while (currentNumber <= m) {
                    if (isPrime(currentNumber)) {
                        primeFound++;
                    }

                    currentNumber++;
                }
                System.out.println(primeFound);
            }
        }
    }

}