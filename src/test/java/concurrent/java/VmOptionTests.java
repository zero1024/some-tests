package concurrent.java;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class VmOptionTests {

    @Test
    public void testNpe() {
        String s = null;
        NullPointerException npe = null;
        try {
            System.out.println(s.toString());
        } catch (NullPointerException e) {
            npe = e;
        }
        assertTrue(npe.getMessage().contains("because \"s\" is null"));
    }
}
