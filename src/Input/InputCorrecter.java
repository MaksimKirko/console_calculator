package Input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MadMax on 13.09.2016.
 */
public class InputCorrecter {
    public InputCorrecter() {
    }

    public String deleteSpaces(String s) {
        return s.replaceAll(" ", "");
    }

    public boolean isCorrect(String s) {
        Pattern p = Pattern.compile("(^[0-9]+.*[0-9])|(^-.*[0-9])");
        Pattern p1 = Pattern.compile(".*((\\*)|/|(\\+)|-)((\\*)|/|(\\+)|--+).*");
        Matcher m = p.matcher(s);
        Matcher m1 = p1.matcher(s);
        Pattern p2 = Pattern.compile(".*[a-zA-Z]+.*");
        Matcher m2 = p2.matcher(s);
        if(m.matches() && !m1.matches() && !m2.matches()) {
            return true;
        }
        return false;
    }
}
