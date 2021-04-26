package feature.java;

import org.apache.commons.io.input.ReaderInputStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class StreamTest {

    @Test
    void testInputStreamToString() throws IOException {
        InputStream inputStream = new ReaderInputStream(new StringReader("something"), "UTF-8");

        int i;
        var writer = new StringWriter();
        while ((i = inputStream.read()) != -1) {
            writer.write(i);
        }

        System.out.println(writer.toString());


    }
}
