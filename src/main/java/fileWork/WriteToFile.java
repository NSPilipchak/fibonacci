package fileWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {
    private static final Logger logger = LogManager.getRootLogger();

    public static void toFile(ArrayList<String> data) {
        logger.info("3. Store result to output.txt");
        String fileName = "output.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < data.size(); i++) {
                bw.write(data.get(i));
                if (i != data.size() - 1)
                    bw.newLine();
            }
        } catch (IOException ex) {
            logger.error("error message: " + ex.getMessage());
            logger.fatal("fatal error message: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
