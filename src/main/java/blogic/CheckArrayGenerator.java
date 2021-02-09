package blogic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CheckArrayGenerator implements CheckArray {
    private static final Logger logger = LogManager.getRootLogger();
    private Fibonacci fibo;

    @Override
    public void checkFibo(ArrayList<String> arrayList) {
        logger.info("1. lines based on Fibonacci sequence:");
        logger.info("Check with Fibonacci number generator");
        fibo = new Fibonacci();
        fibo.init();
        arrayList.removeIf(s -> !rowIsFibo(s));

        if (logger.isDebugEnabled())
            logger.info(print(arrayList));
    }

    private boolean rowIsFibo(String row) {
        for (int num : fibo.getFibonacciArray()) {
            if (digitOnlyFromRow(row) == num)
                return true;
        }
        return false;
    }

    private int digitOnlyFromRow(String row) {
        String digitOnly = row.replaceAll("[^0-9]", "");
        return Integer.parseInt(digitOnly);
    }
}
