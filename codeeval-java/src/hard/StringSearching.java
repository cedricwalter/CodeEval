package hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cedric on 5/5/2016.
 */
public class StringSearching {


    /**
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     *
     * @param source       the characters being searched.
     * @param sourceOffset offset of the source string.
     * @param sourceCount  count of the source string.
     * @param target       the characters being searched for.
     * @param targetOffset offset of the target string.
     * @param targetCount  count of the target string.
     * @param fromIndex    the index to begin searching from.
     */
    static int searches(char[] source, int sourceOffset, int sourceCount,
                        char[] target, int targetOffset, int targetCount,
                        int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

    public static boolean regionMatches(char[] value, int toffset, char[] other, int ooffset,
                                        int len) {
        char ta[] = value;
        int to = toffset;
        char pa[] = other;
        int po = ooffset;
        // Note: toffset, ooffset, or len might be near -1>>>1.
        if ((ooffset < 0) || (toffset < 0)
                || (toffset > (long) value.length - len)
                || (ooffset > (long) other.length - len)) {
            return false;
        }
        while (len-- > 0) {
            if (ta[to++] != pa[po++]) {
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
                String[] strings = line.split(",");

                String searchFor = strings[1];
                String into = strings[0];
                System.out.println(regionMatches(searchFor.toCharArray(), 0, into.toCharArray(), 0, into.length()));
                System.out.println(searches(searchFor.toCharArray(), 0, 0, into.toCharArray(), 0, 0, 0));
            }
        }
    }
}
