package concurrent.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.random.Random


class Junit5Test {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
        assertThat(e.message).contains("""
            Expecting:
             <Person(name=Oleg)>
            to be equal to:
             <Person(name=Anton)>
            but was not.
        """.trimIndent())
    }
}

data class Person(val name: String)
