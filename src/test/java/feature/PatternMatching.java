package feature;

import org.junit.jupiter.api.Test;

public class PatternMatching {


    @Test
    void testPatternMatching() {
        Object o = 1;
        if (o instanceof Integer i) {
            System.out.println("Integer's value - " + i);
        } else if (o instanceof String s) {
            System.out.println("String's value - " + s);
        }
    }


}
