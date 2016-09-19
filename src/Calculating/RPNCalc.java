package Calculating;

import java.util.*;

/**
 * Created by MadMax on 04.09.2016.
 */

//3+4*2/(1-5)^2
//342*15-2^/+
public class RPNCalc {
    private String inputStr;
    private List<String> outputStr;
    private Stack<String> delimeters;
    private int index = 0; //variable to keep current string index
    private MathOperations math;

    public RPNCalc(String s) {
        inputStr = s;
        outputStr = new ArrayList<String>();
        delimeters = new Stack<String>();
        math = new MathOperations();
    }

    public String getResult() {
        convertToRPN();
        calculate();
        return outputStr.get(0);
    }

    private void calculate() {
        for(int i = 0; i < outputStr.size(); i++) {
            if(!math.isNumber(outputStr.get(i))) {
                String res = "" + math.getOerationResult(outputStr.get(i - 2),
                        outputStr.get(i - 1), outputStr.get(i));
                outputStr.set(i, "");
                outputStr.set(i, res);
                outputStr.remove(i - 1);
                outputStr.remove(i - 2);
                calculate();
            }
        }
    }

    private void convertToRPN() {
        while(index < inputStr.length()) {
            getNumber(inputStr.substring(index));
            getDelimiter(inputStr.substring(index));
        }
        while (!delimeters.isEmpty()) {
            outputStr.add(delimeters.pop());
        }
    }


    private void getNumber(String s) {
        String res = "";

        if(!Character.isDigit(s.charAt(0))) {
            if(s.charAt(0) == '-' &&
                    !Character.isDigit(inputStr.charAt(index - 1)) &&
                    inputStr.charAt(index - 1) != ')') {
                res += "-";
                s = s.substring(1);
            }
            else return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) {
                if(s.charAt(i) == '.') {
                    if(s.substring(0, i).contains(".")) {
                        System.err.println("Incorrect input in position " + i + ": there are no numbers with two dots.");
                        System.exit(0);
                    }
                    else {
                        continue;
                    }
                }
                index += i;
                res += s.substring(0, i);
                break;
            }
            else if(i == s.length() - 1) {
                index++;
                res += s.charAt(0);
            }
        }

        outputStr.add(res);
    }

    private void getDelimiter(String s) {
        if(index >= inputStr.length()) {
            return;
        }
        s = "" + s.charAt(0);

        if(!delimeters.isEmpty()) {
            while(math.getPriority(s) <= math.getPriority(delimeters.peek())) {
                if(s.equals("(")) {
                    delimeters.push(s);
                    index++;
                    return;
                }
                if(delimeters.peek().equals("(") && s.equals(")")) {
                    delimeters.pop();
                    index++;
                    return;
                }
                else if(delimeters.peek().equals("(")) {
                    break;
                }
                outputStr.add(delimeters.pop());
                if(delimeters.isEmpty()) break;
            }
        }
        delimeters.push(s);
        index++;
    }
}
