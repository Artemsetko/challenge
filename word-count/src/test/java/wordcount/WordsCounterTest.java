package wordcount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsCounterTest {

    WordsCounter wordsCounter;

    @Before
    public void setUp() throws Exception {
        wordsCounter = new WordsCounter();
    }


    @Test
    public void wordCountShouldReturnTrue() throws IOException {
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("one", 1);
        expectedMap.put("two", 1);
        expectedMap.put("three", 2);
        expectedMap.put("four", 1);
        expectedMap.put("five", 1);
        expectedMap.put("six", 4);
        expectedMap.put("seven", 1);
        expectedMap.put("eight",1);
        expectedMap.put("nine", 3);
        expectedMap.put("ten", 1);

        Map<String, Integer> actualMap = wordsCounter.wordCount(wordsCounter.readWordsFromFile("test.txt"));
        Assert.assertEquals(expectedMap, actualMap);
    }

    @Test(expected = NullPointerException.class)
    public void wordCountShouldThrowNullPointerException(){
        wordsCounter.wordCount(null);
    }

    @Test
    public void readWordsFromFileShouldReturnTrue() throws IOException {
        //given
        List<String> expectedList = Arrays.asList("one", "two", "three", "three", "four",
                "five", "six", "six", "six", "six", "seven", "eight", "nine", "nine", "nine", "ten");
        //when
        List<String> actualList = wordsCounter.readWordsFromFile("test.txt");

        //then
        Assert.assertEquals(actualList, expectedList);
    }

    @Test(expected = NullPointerException.class)
    public void readWordsFromFileShouldThrowExceptionWhenFileDoesNotExist() throws IOException {
        List<String> actualList = wordsCounter.readWordsFromFile("WrongName.txt");
    }
}