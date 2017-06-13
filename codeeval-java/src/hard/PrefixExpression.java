package hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 * Created by cedric on 5/5/2016.
 */
public class PrefixExpression {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] split = line.split(" ");

                Stack<Double> stack = new Stack<>();
                for (int i = split.length - 1; i >= 0; i--) {
                    String element = split[i];
                    if (!element.matches("[+-/*]")) {
                        stack.push(Double.parseDouble(element));
                    } else {
                        Double op1 = stack.pop();
                        Double op2 = stack.pop();
                        Double result = 0.0;
                        if (element.equals("+")) {
                            result = op1 + op2;
                        } else if (element.equals("-")) {
                            result = op1 - op2;
                        } else if (element.equals("/")) {
                            result = op1 / op2;
                        } else if (element.equals("*")) {
                            result = op1 * op2;
                        }
                        stack.push(result);
                    }
                }
                System.out.println(stack.pop().intValue());
            }
        }
    }
}