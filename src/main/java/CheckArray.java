import java.util.ArrayList;

public class CheckArray {
    private final ArrayList<String> arrayList;
    private final Fibonacci fibo;

    public CheckArray(ArrayList<String> arrayList, Fibonacci fibo) {
        this.arrayList = arrayList;
        this.fibo = fibo;
    }

    public void checkFibo() {
        arrayList.removeIf(s -> !rowIsFibo(s));
    }

    private boolean rowIsFibo(String row) {
        for (int i : fibo.getFibonacci()) {
            if (digitOnlyFromRow(row) == i)
                return true;
        }
        return false;
    }

    private int digitOnlyFromRow(String row) {
        String digitOnly = row.replaceAll("[^0-9]", "");
        return Integer.parseInt(digitOnly);
    }
}
