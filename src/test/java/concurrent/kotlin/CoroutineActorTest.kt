package concurrent.kotlin

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import org.junit.jupiter.api.Test
import kotlin.coroutines.CoroutineContext

class CoroutineActorTest {


    @Test
    fun testInc() {
        val actor = GlobalScope.counterActor()
        val job = GlobalScope.launch {
            printThreadName()
            actor.send(IncCounter)
            val res = CompletableDeferred<Int>()
            actor.send(GetCounter(res))
            println(res.await())
        }
        runBlocking {
            job.join()
        }
        runBlocking {
            printThreadName()
            actor.send(IncCounter)
            val res = CompletableDeferred<Int>()
            actor.send(GetCounter(res))
            println(res.await())
        }
    }

}

sealed class CounterMsg
object IncCounter : CounterMsg()
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()

fun CoroutineScope.counterActor(
    context: CoroutineContext = Dispatchers.Unconfined
) = actor<CounterMsg>(context = context, block = {
    var counter = 0
    for (msg in channel) {
        printThreadName()
        when (msg) {
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
})

private fun printThreadName() {
    println(Thread.currentThread().name)
}