package wordcount;

import java.util.Map;

public class Printer {

    private Printer() {

    }

    public static void printResult(Map<String, Integer> words) {
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }

    public static void printInfo() {
        System.out.println("This program produce a count of all the different \"words\" in a text file" +
                "\n" + "and prints result in the console " +
                "\n" + "You should input name of file, which is stored in the resources folder");
    }
}
