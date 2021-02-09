public class Fibonacci {
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

    static boolean isFibonacci(long num) {
        final long fiveTimesSquare = 5 * num * num;
        return isPerfectSquare(fiveTimesSquare + 4) || isPerfectSquare(fiveTimesSquare - 4);
    }

    private static boolean isPerfectSquare(long n) {
        final double root = Math.sqrt(n);                           // возвращаем квадратный корень числа
        return Double.compare(root, Math.floor(root)) == 0;
    }

    public int[] getFibonacci() {
        return fibonacci;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
