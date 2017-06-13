package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by cedric on 4/29/2016.
 */
public class Fibonnaci {


    public static BigInteger getFibonacci(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) <= 0) {
            return n;
        }
        BigInteger x = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;
        BigInteger result = BigInteger.ZERO;

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = x.add(y);
            x = y;
            y = result;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                System.out.println(getFibonacci(new BigInteger(line)));
            }
        }
    }

}
