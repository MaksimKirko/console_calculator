package Input;

import java.util.Scanner;

/**
 * Created by MadMax on 02.09.2016.
 */
public class Reader implements IReader {
    @Override
    public String consoleInput() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }
}
