package lochaqc.helpers;

import java.io.File;

public class SystemsHelper {
    // Ham lay Path tuyet doi của project
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
