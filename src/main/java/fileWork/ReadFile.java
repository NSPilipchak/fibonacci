package fileWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    static final Logger logger = LogManager.getRootLogger();

    private final ArrayList<String> arrayList = new ArrayList<>();

    public ReadFile(String path) {
        logger.info("input file: " + path);
        try (FileReader fileReader = new FileReader(path);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (IOException ex) {
            logger.error("error: " + ex.getMessage());
            logger.fatal("fatal error: " + ex.getMessage());
            System.exit(0);
        }
        if (logger.isInfoEnabled())
            print();
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    private void print() {
        StringBuilder str = new StringBuilder("Loaded rows:");
        for (String line : arrayList) {
            str.append("\n");
            str.append(line);
        }
        logger.info(str);
    }
}
