package Calculating;

/**
 * Created by MadMax on 11.09.2016.
 */
public class MathOperations {
    public MathOperations() {

    }

    public byte getPriority(String s) {
        char c = s.charAt(0);
        switch (c) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 4;
        }
    }

    public double getOerationResult(String a, String b, String op) {
        double first = Double.parseDouble(a);
        double second = Double.parseDouble(b);

        switch (op.charAt(0)) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                if(second != 0) {
                    return first / second;
                }
                else {
                    System.err.println("Incorrect action : division by zero.");
                    System.exit(0);
                }
            case '^':
                return Math.pow(first, second);
        }
        return 0;
    }

    public boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
