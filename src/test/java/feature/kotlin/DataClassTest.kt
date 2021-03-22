package feature.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DataClassTest {

    //data class can extend, but can't be extended
    data class Person(val name: String, var age: Int) : HashMap<String, Any>()

    @Test
    fun testMutability() {
        val person = Person("Oleg", 12)
        person.age = 13
        assertThat(person.age).isEqualTo(13)
    }


}