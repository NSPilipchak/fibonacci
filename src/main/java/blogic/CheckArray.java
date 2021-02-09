package blogic;

import java.util.ArrayList;

public interface CheckArray {

    void checkFibo(ArrayList<String> arrayList);

    default StringBuilder print(ArrayList<String> arrayList) {
        StringBuilder str = new StringBuilder("Checked:");
        for (String line : arrayList) {
            str.append("\n");
            str.append(line);
        }
        return str;
    }
}
