package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChardonnayOrCabernet {

    private static final String BLANK_SPACE = " ";
    private static final String SEPARATOR = "\\|";

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] numStrings = line.split(SEPARATOR);
            String[] words = numStrings[0].trim().split(BLANK_SPACE);
            String charactersToSearchFor = numStrings[1].trim();

            List<String> wordList = new ArrayList<>();

            for (String word : words) {
                boolean allCharacterFound = true;
                String analyzingWord = word;

                for (int j = 0; j < charactersToSearchFor.length(); j++) {
                    String s = Character.toString(charactersToSearchFor.charAt(j));
                    if (!analyzingWord.contains(s)) {
                        allCharacterFound = false;
                        break;
                    } else {
                        analyzingWord = analyzingWord.replaceFirst(s, "");
                    }
                }

                if (allCharacterFound) {
                    wordList.add(word);
                }
            }

            if (wordList.size() == 0) {
                System.out.println("False");
            } else {
                System.out.println(wordList.stream().collect(Collectors.joining(BLANK_SPACE)));
            }
        }
    }

}
