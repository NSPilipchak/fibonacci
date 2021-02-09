package blogic;

import java.util.ArrayList;

public interface CheckArray {

    void checkFibo(ArrayList<String> arrayList);

    default StringBuilder print(ArrayList<String> arrayList) {
        StringBuilder ret = new StringBuilder("Checked:");
        for (String line : arrayList) {
            ret.append("\n");
            ret.append(line);
        }
        return ret;
    }
}
