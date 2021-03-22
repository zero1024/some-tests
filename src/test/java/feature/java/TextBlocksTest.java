package feature.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBlocksTest {

    @Test
    void slashToIgnoreNewLines() {
        var s = """
                first
                second \
                third""";
        assertThat(s).isEqualTo("first\nsecond third");
    }

}
