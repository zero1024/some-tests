package feature.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Java14 {

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

    @Test
    void testPatternMatching() {
        Object o = 1;
        if (o instanceof Integer i) {
            System.out.println("Integer's value - " + i);
        } else if (o instanceof String s) {
            System.out.println("String's value - " + s);
        }
    }

    @Test
    void slashToIgnoreNewLines() {
        var s = """
                first
                second \
                third""";
        assertThat(s).isEqualTo("first\nsecond third");
    }

    @Test
    void testRecord() {
        Person person1 = new Person("Oleg", "Perekhod");
        Person person2 = new Person("Oleg", "Perekhod");
        Person person3 = new Person("Anton", "Perekhod");

        assertThat(person1).isEqualTo(person2);
        assertThat(person1).isNotEqualTo(person3);
    }

    private static record Person(String name, String lastName) {

    }


}
