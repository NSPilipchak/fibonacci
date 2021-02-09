import blogic.CheckArray;
import blogic.CheckArrayAccount;
import blogic.CheckArrayGenerator;
import blogic.Revers;
import fileWork.InputFile;
import fileWork.ReadFile;
import fileWork.WriteToFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class AppMain {
    static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        if (logger.isDebugEnabled()) {
            logger.debug("Logger: In debug message");
        }
        //get file patch or load default file
        InputFile inputFile = new InputFile();

        //read file
        ReadFile rFile = new ReadFile(inputFile.getInputFile());

        //get array from file
        ArrayList<String> data = rFile.getArrayList();

        //сhecking the received data
        //Option 1 Checking the ArrayList to see if the digit in the string matches the generated Fibonacci numbers
        CheckArray checkArray = new CheckArrayGenerator();

        //Option 2 Checking ArrayList for correspondence of the number in the string to the Fibonacci number using the formula
//        CheckArray checkArray = new CheckArrayAccount();

        checkArray.checkFibo(data);

        //apply revers of the row
        Revers.reversStringInArray(data);

        //Store result to the new file output.txt
        WriteToFile.toFile(data);
    }
}
