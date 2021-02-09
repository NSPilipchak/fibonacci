package blogic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {
    private static final Logger logger = LogManager.getRootLogger();
    private int[] fibonacciArray;
    private int size = 47;  //int can save 32 bit num (from -2147883648 to 2147883647)

    public Fibonacci() {
    }

    public void init() {
        fibonacciArray = new int[size];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i < size; ++i) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        if (logger.isInfoEnabled())
            print();
    }

    private void print() {
        StringBuilder ret = new StringBuilder("Fibonacci number: ");
        for (int i = 0; i < size; ++i) {
            ret.append(fibonacciArray[i]);
            if (i != size - 1)
                ret.append(", ");
        }
        logger.info(ret);
    }

    public int[] getFibonacciArray() {
        return fibonacciArray;
    }
}
