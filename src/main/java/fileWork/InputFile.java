package fileWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class InputFile {
    private static final Logger logger = LogManager.getRootLogger();
    private String inputFile;

    public InputFile() {
        if (logger.isDebugEnabled()) {
            logger.info("Logger: get input file");
        }

        System.out.print("Path to input file, or press Enter for the default file (source.txt): ");
        Scanner scanner = new Scanner(System.in);
        inputFile = scanner.nextLine();
        if (inputFile.length() == 0)
            inputFile = "source.txt";
    }

    public String getInputFile() {
        return inputFile;
    }
}
