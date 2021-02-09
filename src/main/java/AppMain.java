import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class AppMain {
    static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        //debug
        if (logger.isDebugEnabled()) {
            logger.debug("Logger: In debug message");
        }
        //получаем путь к файлу, либо грузим дефолтно
        InputFile inputFile = new InputFile();

        //получаем массив данных из файла
        ArrayList<String> data = ReadFile.readFileData(inputFile.getInputFile());

        //выводим полученные данные в консоль
        for (String line : data) {
            System.out.println(line);
        }

        //Проверяем полученные данные на соответсвие числу Фибоначчи
        //1. Генерируем массив с числами Фибоначи, и выводи в консоль
        Fibonacci f = new Fibonacci();
        f.init();
        System.out.println(f.toString());

        //2. Проверяем ArrayList на соответсвие цифры в строке числу Фибоначчи
        CheckArray checkArray = new CheckArray(data, f);
        checkArray.checkFibo();

        System.out.println("после чека");
        for (String line : data) {
            System.out.println(line);
        }

        //3. реверсируем значения в масиве // apply revers of the row
        Revers.reversStringInArray(data);

        System.out.println("после реверса");
        for (String line : data) {
            System.out.println(line);
        }

        //Store result to the new file output.txt
        WriteToFile.toFile(data);
    }
}
