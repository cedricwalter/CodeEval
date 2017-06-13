package easy;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/1/2016.
 */
public class BigDigits {

    static int LETTER_WIDTH = 4;
    static int LETTER_SEPARATOR = 1;
    static String SEPARATOR = "-";

    static String line1 = "-**----*--***--***---*---****--**--****--**---**--";
    static String line2 = "*--*--**-----*----*-*--*-*----*-------*-*--*-*--*-";
    static String line3 = "*--*---*---**---**--****-***--***----*---**---***-";
    static String line4 = "*--*---*--*-------*----*----*-*--*--*---*--*----*-";
    static String line5 = "-**---***-****-***-----*-***---**---*----**---**--";

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String cleaned = line.replaceAll("[^\\d.]", "").replace(".", "");

                displayLine(line1, cleaned);
                displayLine(line2, cleaned);
                displayLine(line3, cleaned);
                displayLine(line4, cleaned);
                displayLine(line5, cleaned);
                displaySeparator(cleaned);
            }
        }
    }

    private static void displaySeparator(String cleaned) {
        System.out.println(new String(new char[cleaned.length() * (LETTER_WIDTH + LETTER_SEPARATOR)]).replace("\0", SEPARATOR));
    }

    private static void displayLine(String line1, String cleaned) {
        for (int i = 0; i < cleaned.length(); i++) {
            int i1 = Integer.parseInt(String.valueOf(cleaned.charAt(i)));

            int start = i1 * LETTER_WIDTH + i1 * LETTER_SEPARATOR;
            int end = start + LETTER_WIDTH;
            System.out.print(line1.substring(start, end) + SEPARATOR);
        }
        System.out.println("");
    }


}
