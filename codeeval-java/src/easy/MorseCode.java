package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cedric on 5/2/2016.
 */
public class MorseCode {

    static Map converter = new HashMap<>();

    static {
        converter.put(".-", "A");
        converter.put("-...", "B");
        converter.put("-.-.", "C");
        converter.put("-..", "D");
        converter.put(".", "E");
        converter.put("..-.", "F");
        converter.put("--.", "G");
        converter.put("....", "H");
        converter.put("..", "I");
        converter.put(".---", "J");
        converter.put("-.-", "K");
        converter.put(".-..", "L");
        converter.put("--", "M");
        converter.put("-.", "N");
        converter.put("---", "O");
        converter.put(".--.", "P");
        converter.put("--.-", "Q");
        converter.put(".-.", "R");
        converter.put("...", "S");
        converter.put("-", "T");
        converter.put("..-", "U");
        converter.put("...-", "V");
        converter.put(".--", "W");
        converter.put("-..-", "X");
        converter.put("-.--", "Y");
        converter.put("--..", "Z");
        converter.put(".----", "1");
        converter.put("..---", "2");
        converter.put("...--", "3");
        converter.put("....-", "4");
        converter.put(".....", "5");
        converter.put("-....", "6");
        converter.put("--...", "7");
        converter.put("---..", "8");
        converter.put("----.", "9");
        converter.put("-----", "0");
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String l;
        while ((l = in.readLine()) != null) {
            String[] codes = l.split(" ");
            for (String code : codes) {
                System.out.print(code.equals("") ? " " : converter.get(code));
            }
            System.out.println("");
        }
    }


}
