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
    private static final Logger logger = LogManager.getRootLogger();
    private static String inputFileName = "";
    private static String outputFileName = "";
    private static boolean generateFibo = true;


    /**
     *
     * @param args -i input file name
     *             -o output file name
     *             -a turn off generator Fibonacci num
     *             Example: -i source.txt -o output.txt -a
     */
    public static void main(String[] args) {
        if (logger.isDebugEnabled()) {
            logger.debug("Logger: In debug message");
        }
        if (args.length > 0)
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-i":
                        inputFileName = args[i + 1];
                        logger.info("Selected input file name: " + inputFileName);
                        break;
                    case "-o":
                        outputFileName = args[i + 1];
                        logger.info("Selected output file name: " + outputFileName);
                        break;
                    case "-a":
                        generateFibo = false;
                        logger.info("Selected turnOff generate Fibonacci");
                        break;
                }
            }
        else {
            logger.info("Command line parameter not find");
        }
        start();
    }

    private static void start() {
        // check selected input files from command line
        if (inputFileName.length() == 0) {
            //get file patch or load default file
            InputFile inputFile = new InputFile();
            inputFileName = inputFile.getInputFile();
            //read file
        }
        ReadFile rFile = new ReadFile(inputFileName);

        //get array from file
        ArrayList<String> data = rFile.getArrayList();

        //сhecking the received data

        CheckArray checkArray;
        if (generateFibo)
            checkArray = new CheckArrayGenerator();     //Option 1 Checking the ArrayList to see if the digit in the string matches the generated Fibonacci numbers
        else
            checkArray = new CheckArrayAccount();       //Option 2 Checking ArrayList for correspondence of the number in the string to the Fibonacci number using the formula


        checkArray.checkFibo(data);

        //apply revers of the row
        Revers.reversStringInArray(data);

        //Store result to the new file output.txt
        WriteToFile.toFile(data, outputFileName);
    }
}
