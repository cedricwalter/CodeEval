package sponsored;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/9/2016.
 */
public class ColumnsNames {

    static int ALPHA26 = 26;

    public static String base10toAlpha26(int column) {
        StringBuilder alpha26 = new StringBuilder();
        int columnRemaining = column;

        while (columnRemaining > 0) {
            int currentColumn = columnRemaining % ALPHA26;
            if (currentColumn == 0) {
                currentColumn = ALPHA26;
            }
            columnRemaining = (columnRemaining - currentColumn) / ALPHA26;

            char columnChar = (char) (currentColumn + Character.valueOf('A') - 1);
            alpha26.insert(0, columnChar);
        }

        return alpha26.toString();
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String column;
        while ((column = in.readLine()) != null) {
            int number = Integer.parseInt(column);
            System.out.println(base10toAlpha26(number));
        }

    }

}
