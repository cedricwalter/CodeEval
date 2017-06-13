package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cedric on 5/9/2016.
 */
public class EmailValidation {
    private static String domain = "(\\.[A-Za-z]{2,})";
    private static String any = "[A-Za-z0-9]+";
    private static String any_with_hyphen = "[_A-Za-z0-9-]+";
    private static String any_with_dash = "[A-Za-z0-9-]+";
    private static final String OR = "|";

    private static final String words = "(\\." + any + ")*";

    static final String patternString =
            "^[_A-Za-z0-9-\\.\\+]+(\\." + any_with_hyphen + ")*@" + any_with_dash + words + domain + "$" + OR +
                    "^\"[_A-Za-z0-9-\\.\\+@]+(\\." + any_with_hyphen + ")*\"@" + any_with_dash + words + domain + "$";

    static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);


    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(line);
                System.out.println(matcher.find());
            }
        }
    }

}
