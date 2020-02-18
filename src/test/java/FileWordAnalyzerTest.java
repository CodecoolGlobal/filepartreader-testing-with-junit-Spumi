import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class FileWordAnalyzerTest {
    FilePartReader fpr = null;
    String sourcePath = "src/test/java/";

    @BeforeEach
    void setUp() {
        fpr = new FilePartReader();
        try {
            fpr.setup("src/test/java/testData.txt", 1, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        fpr = null;
    }

    @Test
    void getWordsOrderedAlphabetically() throws Exception {
        fpr.setup(sourcePath + "alphabet.txt", 1, 3);
        FileWordAnalyzer fwr = new FileWordAnalyzer(fpr);
        ArrayList<String> test = new ArrayList<>(Arrays.asList("alma", "banan", "barack"));
        assertLinesMatch(test, fwr.getWordsOrderedAlphabetically());
    }

    @Test
    void getWordsContainingSubstring() throws Exception {
        fpr.setup(sourcePath + "alphabet.txt", 1, 3);
        FileWordAnalyzer fwr = new FileWordAnalyzer(fpr);
        ArrayList<String> excepted = new ArrayList<>(Arrays.asList("alma", "banan", "barack"));
        ArrayList<String> actual = (ArrayList<String>) fwr.getWordsContainingSubstring("a");
        Collections.sort(actual);
        assertLinesMatch(excepted, actual);
    }

    @Test
    void getStringsWhichPalindromes() throws Exception {
        FileWordAnalyzer fwr = new FileWordAnalyzer(fpr);
        fpr.setup(sourcePath + "testData.txt", 4, 7);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("aaaa", "abba"));
        ArrayList<String> actual = (ArrayList<String>) fwr.getStringsWhichPalindromes();
        assertLinesMatch(actual, expected);
    }
}