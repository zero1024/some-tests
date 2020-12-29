package concurrent.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.random.Random


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class Junit5Test {

    @Nested
    inner class TestLifecycleTest {

        private val testPerson = Person(Random.Default.nextInt(1000).toString())

        @Test
        fun testLifecycle1() {
            println("this is test 1: Generated person name: ${testPerson.name}")
        }

        @Test
        fun testLifecycle2() {
            println("this is test 2: Generated person name: ${testPerson.name}")
        }
    }


    @Test
    internal fun dataClassAssertionsTest() {
        val person = Person("Oleg")
        val e = catchThrowable { assertThat(person).isEqualTo(Person("Anton")) }
        assertThat(e.message).contains(
            """
            Expecting:
             <Person(name=Oleg)>
            to be equal to:
             <Person(name=Anton)>
            but was not.
        """.trimIndent()
        )
        assertThat(person)
            .usingRecursiveComparison()
            .ignoringFields("name")
            .isEqualTo(Person("Anton"))
    }

    @ParameterizedTest
    @MethodSource("intPairProvider")
    fun paramTest(testData: Pair<Int, String>) {
        assertThat(testData.first.toString()).isEqualTo(testData.second)
    }

    private fun intPairProvider() = Stream.of(
        1 to "1",
//        1 to "2",
        3 to "3"
    )
}

data class Person(val name: String)
