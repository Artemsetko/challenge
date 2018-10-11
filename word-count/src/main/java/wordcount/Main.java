package wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        startProgram();
    }

    private static void startProgram() throws IOException {
        System.out.println("Please, enter the name of the file that is stored in the resources folder");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if (fileName.length() == 0 || fileName.equalsIgnoreCase("help")) {
            Printer.printInfo();
        } else {
            WordsCounter wordsCounter = new WordsCounter();
            Map<String, Integer> result = wordsCounter.wordCount(wordsCounter.readWordsFromFile(fileName));
            Printer.printResult(result);
        }
    }
}
