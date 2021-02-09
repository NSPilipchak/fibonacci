package blogic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Revers {
    private static final Logger logger = LogManager.getRootLogger();

    public static void reversStringInArray(ArrayList<String> arrayList) {
        logger.info("2. Revers:");
        logger.info("reversStringInArray - input array: " + arrayList.toString());

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, revers(arrayList.get(i)));
        }

        logger.info("reversStringInArray - output array: " + arrayList.toString());
    }

    private static String revers(String str) {
        if (str == null) {
            logger.warn("reversString - input: " + str);
            return null;
        }

        logger.debug("reversString - input: " + str);
        char[] arr = str.toCharArray();
        StringBuilder ret = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            ret.append(arr[i]);
        }
        logger.debug("reversString - output: " + ret);
        return ret.toString();
    }
}
