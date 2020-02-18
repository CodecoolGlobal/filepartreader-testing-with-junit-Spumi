import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    FilePartReader fpr;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public List getWordsOrderedAlphabetically() throws IOException {
        List ordered = new ArrayList<String>();
            ordered = Arrays.stream(fpr.readLines()
                    .split("[\\W+]"))
                    .sorted()
                    .collect(Collectors.toList());
        return ordered;
    }

    public List getWordsContainingSubstring(String subString) throws IOException {
        List<String> results = new ArrayList<>();
            results = Arrays.stream(fpr.readLines()
                    .split("[\\W+]"))
                    .filter(x -> x.contains(subString))
                    .collect(Collectors.toList());
        return results;
    }

    public List getStringsWhichPalindromes() throws IOException {
        List<String> results = new ArrayList<>();
            results = Arrays.stream(fpr.readLines()
                    .split("[\\W+]"))
                    .filter(x -> {
                        for (int i = 0; i <= x.length() / 2; i++) {
                            if (x.charAt(i) != x.charAt(x.length() -1 - i)) {
                                return false;
                            }
                        }
                        return true;
                    })
                    .collect(Collectors.toList());
        return results;
    }

}
