import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest2 {
    FilePartReader fpr = null;

    @BeforeEach
    void setUp() {
        fpr = new FilePartReader();
    }


    @Test
    @DisplayName("Should throw IoException")
    void setup() throws Exception{
        assertThrows(IOException.class , () -> {fpr.setup("asd",1,4);});
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException")
    public void setupWithWrongArgument(){
        assertThrows(IllegalArgumentException.class , () -> {fpr.setup("e:\\test.txt",6,4);});
    }

    @Test
    void read() {
    }

    @Test
    void readLines() {
    }
}