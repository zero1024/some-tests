package concurrent.kotlin

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import org.junit.jupiter.api.Test
import kotlin.coroutines.coroutineContext

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

    @ObsoleteCoroutinesApi
    @Test
    fun testNestedExecution() {
        runBlocking {
            launch {
                delay(10000)
                println("Nested launch is done!")
            }
            val res = async {
                delay(10000)
                println("Nested async is done!")
            }
            val actor = actor<Int> {
                for (i in channel) {
                    println(i)
                }
                println("Nested actor is done!")
            }
            coroutine1()
            coroutine2()
            delay(1000)
            actor.close()
            println("Outer launch is done!")
        }
    }

    fun CoroutineScope.coroutine1() {
        launch {
            delay(15000)
            println("Launch from method is done! As expected!")
        }
    }

    fun CoroutineScope.coroutine2() {
        GlobalScope.launch {
            delay(16000)
            println("Launch from method is done! Not expected!")
        }
    }

}