package feature.java;

import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.util.HashMap;

import static org.apache.commons.io.FileUtils.byteCountToDisplaySize;

public class GCTest {

    /**
     * -verbose:gc -XX:+UseZGC -Xlog:gc*
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

    /**
     * -Xmx512m -Xms128m
     */
    @Test
    void testDefaultXmx() {
        var memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println("Init:" + byteCountToDisplaySize(memoryMXBean.getHeapMemoryUsage().getInit()));
        System.out.println("Used:" + byteCountToDisplaySize(memoryMXBean.getHeapMemoryUsage().getUsed()));
        System.out.println(("Max:" + byteCountToDisplaySize(memoryMXBean.getHeapMemoryUsage().getMax())));
    }
}
