package concurrent.kotlin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.random.Random

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestLifecycleTest {

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

data class Person(val name: String)
