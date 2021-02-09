package blogic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {
    static final Logger logger = LogManager.getRootLogger();
    private int[] fibonacci;
    private int size = 47;  //int позволяет хранить 32 битное целочисленое значение (от -2147883648 до 2147883647)

    public Fibonacci() {
    }

    public void init() {
        fibonacci = new int[size];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < size; ++i) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        logger.info(toString());
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("Fibonacci number: ");
        for (int i = 0; i < size; ++i) {
            ret.append(fibonacci[i]);
            if (i != size - 1)
                ret.append(", ");
        }
        return ret.toString();
    }

    public int[] getFibonacci() {
        return fibonacci;
    }
}
