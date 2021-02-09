package blogic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CheckArrayAccount implements CheckArray {
    static final Logger logger = LogManager.getRootLogger();

    @Override
    public void checkFibo(ArrayList<String> arrayList) {
        logger.info("1. lines based on Fibonacci sequence:");
        logger.info("Check with Fibonacci by the formula");
        arrayList.removeIf(s -> !rowIsFibo(s));

        if (logger.isInfoEnabled())
            logger.info(print(arrayList));
    }

    private boolean rowIsFibo(String row) {
        final long num = digitOnlyFromRow(row);
        return isFibonacci(num);
    }

    private long digitOnlyFromRow(String row) {
        String digitOnly = row.replaceAll("[^0-9]", "");
        return Long.parseLong(digitOnly);
    }

    static boolean isFibonacci(long num) {
        final long fiveTimesSquare = 5 * num * num;
        return isPerfectSquare(fiveTimesSquare + 4) || isPerfectSquare(fiveTimesSquare - 4);
    }

    private static boolean isPerfectSquare(long n) {
        final double root = Math.sqrt(n);                           // возвращаем квадратный корень числа
        return Double.compare(root, Math.floor(root)) == 0;
    }
}
