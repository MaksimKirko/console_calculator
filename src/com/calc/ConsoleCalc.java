package com.calc;

import Calculating.RPNCalc;
import Input.InputCorrecter;
import Input.Reader;
import Output.Writer;

public class ConsoleCalc {
    //
    // calculator works with +, -, *, /, ^ operators and rational numbers
    //
    public static void main(String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();

        String s = "";
        while (!s.equals("exit")) {
            writer.consoleOutput("Input statement or \"exit\" to finish.");
            s = reader.consoleInput();

            InputCorrecter ic = new InputCorrecter();
            s = ic.deleteSpaces(s);
            if (ic.isCorrect(s)) {
                RPNCalc calc = new RPNCalc(s);
                writer.consoleOutput(calc.getResult());
            }
            else {
                writer.consoleOutput("Input string is incorrect.");
            }
        }
    }
}