package Output;

import java.io.Console;

/**
 * Created by MadMax on 02.09.2016.
 */
public class Writer<T> implements IWriter<T> {
    @Override
    public void consoleOutput(T t) {
        System.out.println("-----------");
        System.out.println(t);
    }
}
