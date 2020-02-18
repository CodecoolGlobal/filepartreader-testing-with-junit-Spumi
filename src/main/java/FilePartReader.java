import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FilePartReader {
    BufferedReader bufferedReader;
    String filePath;
    private int fromLine;
    private int toLinee;

    public FilePartReader() {
    }

    public void setup(String filePath, int fromLine, int toLine) throws Exception {
       bufferedReader = new BufferedReader(new FileReader(filePath));
        this.filePath = filePath;
        if (toLine < fromLine)
            throw new IllegalArgumentException();
        this.fromLine = fromLine - 1;
        this.toLinee = toLine - 1;
    }

    public String read() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line + "\n");
        }
        return sb.toString();
    }

    public String readLines() throws IOException {
        StringBuilder sb = new StringBuilder();
        List<String> lines = read().lines().collect(Collectors.toList());
        for (int i = fromLine; i <= toLinee; i++) {
            sb.append(lines.get(i) + "\n");
        }
        return sb.toString();
    }

}
