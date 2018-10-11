package wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class WordsCounter {

    /**
     *
     * @param strings from file
     * @return map<String, Integer>, where key is a word, value - frequency in a file
     */
    public Map<String, Integer> wordCount(List<String> strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : strings) {

            if (!map.containsKey(s)) {  // first time we've seen this string
                map.put(s, 1);
            } else {
                int count = map.get(s);
                map.put(s, count + 1);
            }
        }
        return map;
    }

    /**
     *
     * @param filename
     * @return all words from File, exclude non-Words.
     * @throws IOException
     */
    public List<String> readWordsFromFile(String filename) throws IOException {
        InputStream is = Main.class.getResourceAsStream("/" + filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        List<String> wordsOfFile = new ArrayList<>();

        String line = reader.readLine();

        while (line != null) {

            // if there is actual content in the line...
            if (!line.trim().equals("")) {
                String[] words = line.split(" ");

                for (String word : words) {
                    String cleanedUpWord = word
                            .replaceAll("\\W", "")
                            .replaceAll("_", "");

                    wordsOfFile.add(cleanedUpWord);
                }
            }
            line = reader.readLine();
        }
        wordsOfFile.removeAll(Arrays.asList(""));
        return wordsOfFile;
    }
}
