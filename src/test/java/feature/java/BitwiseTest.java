package feature.java;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitwiseTest {

    @Test
    void testToBites() {
        assertEquals(toBites(1), "00000000 00000000 00000000 00000001");
        assertEquals(toBites(2), "00000000 00000000 00000000 00000010");
        assertEquals(toBites(0xFF), "00000000 00000000 00000000 11111111");
        assertEquals(toBites(255), "00000000 00000000 00000000 11111111");
    }

    @Test
    void testColorToBites() {
        var color = new Color(100, 150, 200);
        System.out.println(toBites(color.getRGB()));
        System.out.println(toBites(color.getAlpha()));
        System.out.println(toBites(color.getRed()));
        System.out.println(toBites(color.getGreen()));
        System.out.println(toBites(color.getBlue()));
    }

    private static String toBites(int number) {
        var res = new ArrayList<String>();
        for (int degree = 0; degree < 32; degree++) {
            int i = (number >> degree) & 1;
            res.add(Integer.toString(i));
        }
        Collections.reverse(res);
        return IntStream.range(0, 4).boxed()
                .map(i -> String.join("", res.subList(i * 8, i * 8 + 8)))
                .collect(Collectors.joining(" "));
    }

}
