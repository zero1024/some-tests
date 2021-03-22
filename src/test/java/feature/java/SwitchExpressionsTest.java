package feature.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwitchExpressionsTest {

    @Test
    void testSwitchExpression() {
        var inArg = 1;

        var s = switch (inArg) {
            case 1 -> "1";
            case 2 -> "2";
            default -> "null";
        };

        assertThat(s).isEqualTo("1");
    }

}
