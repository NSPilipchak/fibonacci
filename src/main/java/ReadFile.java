import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    static final Logger logger = LogManager.getRootLogger();

    static ArrayList<String> readFileData(String path) {
        ArrayList<String> ret = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                ret.add(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            logger.error("error: " + ex.getMessage());
            logger.fatal("fatal error: " + ex.getMessage());
            System.exit(0);
        }
        return ret;
    }

}
