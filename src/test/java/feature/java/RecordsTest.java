package feature.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordsTest {

    @Test
    void testRecordEquals() {
        Person person1 = new Person("Oleg", "Perekhod");
        Person person2 = new Person("Oleg", "Perekhod");
        Person person3 = new Person("Anton", "Perekhod");

        assertThat(person1).isEqualTo(person2);
        assertThat(person1).isNotEqualTo(person3);
    }

    private static record Person(String name, String lastName) {

    }


}
