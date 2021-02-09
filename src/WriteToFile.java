import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {

    static void toFile(ArrayList<String> data) {
        String fileName = "output.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < data.size(); i++) {
                bw.write(data.get(i));
                if (i != data.size() - 1)
                    bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
