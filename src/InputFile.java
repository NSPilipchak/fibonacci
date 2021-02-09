import java.util.Scanner;

class InputFile {
    private String inputFile;

    InputFile() {
        System.out.print("Path to input file, or press Enter for the default file (source.txt): ");
        Scanner scanner = new Scanner(System.in);
        inputFile = scanner.nextLine();
        if (inputFile.length() == 0)
            inputFile = "source.txt";
    }

    String getInputFile() {
        return inputFile;
    }
}
