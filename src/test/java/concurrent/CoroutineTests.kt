package concurrent

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CoroutineTests {

    @Test
    fun test1() {
        println("Start")
        val c1 = GlobalScope.launch {
            println("We inside coroutine!")
            delay(1000)
            println("We done with coroutine.")
        }
//        Thread.sleep(5000)
        runBlocking {
            delay(5000)
        }
        println("End")
    }
}