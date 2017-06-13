package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/2/2016.
 */
public class RacingChars {

    public static final String RIGHT = "\\";
    public static final String LEFT = "/";
    public static final String STRAIGHT = "|";
    public static final String CHECKPOINT = "C";
    public static final String GATE = "_";

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String section;

        String trackType = "|";
        int previousTrackPosition = 0;
        int newTrackPosition;
        int i = 0;
        String characterToReplace;
        while ((section = in.readLine()) != null) {
            if (section.length() > 0) {
                int gatePos = section.indexOf(GATE);
                int checkPointPos = section.indexOf(CHECKPOINT);

                if (i == 0) {  // Start
                    previousTrackPosition = checkPointPos == -1 ? gatePos : checkPointPos;
                    i++;
                }

                boolean hasCheckpoint = checkPointPos != -1;

                if (hasCheckpoint) {
                    characterToReplace = CHECKPOINT;
                    newTrackPosition = checkPointPos;
                } else {
                    characterToReplace = GATE;
                    newTrackPosition = gatePos;
                }

                if (newTrackPosition > previousTrackPosition) {
                    trackType = RIGHT;
                } else if (newTrackPosition < previousTrackPosition) {
                    trackType = LEFT;
                } else {
                    trackType = STRAIGHT;
                }
                previousTrackPosition = newTrackPosition;

                System.out.println(section.replace(characterToReplace, trackType));
            }
        }
    }
}
