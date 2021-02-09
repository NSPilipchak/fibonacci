import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {
    static final Logger logger = LogManager.getRootLogger();

    static void toFile(ArrayList<String> data) {
        String fileName = "output.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < data.size(); i++) {
                bw.write(data.get(i));
                if (i != data.size() - 1)
                    bw.newLine();
            }
        } catch (IOException e) {
            logger.error("error message: " + e.getMessage());
            logger.fatal("fatal error message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
