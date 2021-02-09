import java.util.ArrayList;

class Revers {
    static ArrayList<String> reversStringInArray(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, revers(arrayList.get(i)));
        }
        return arrayList;
    }


    private static String revers(String str) {
        if (str == null)
            return null;

        char[] arr = str.toCharArray();
        StringBuilder ret = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            ret.append(arr[i]);
        }
        return ret.toString();
    }
}
