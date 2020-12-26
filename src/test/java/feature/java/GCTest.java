package feature.java;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class GCTest {

    /**
     * -verbose:gc -XX:+UseZGC
     */
    @Test
    void testVerboseLogging() {
        for (int i = 0; i < 1000000; i++) {
            new HashMap<>().put(1, 2);
        }
        System.gc();
        for (int i = 0; i < 1000000; i++) {
            new HashMap<>().put(1, 2);
        }
        System.gc();
    }
}
