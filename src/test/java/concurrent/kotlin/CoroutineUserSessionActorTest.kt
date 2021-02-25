package concurrent.kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutineUserSessionActorTest {

    @Test
    fun testUserSessionActor() {

        val userSession = GlobalScope.actor<SessionEvent> {
            for (sessionEvent in channel) {
                printThreadName("session")
                when (sessionEvent) {
                    LoginEvent -> println("Login")
                    LogoutEvent -> println("Logout")
                }
            }
        }

        runBlocking {
            printThreadName("app")
            userSession.send(LoginEvent)
            userSession.send(LoginEvent)
            userSession.send(LogoutEvent)
            userSession.send(LoginEvent)
            printThreadName("app")
        }
        println("End")

//        GlobalScope.launch {
//            printThreadName("app")
//            userSession.send(LoginEvent)
//            userSession.send(LoginEvent)
//            userSession.send(LogoutEvent)
//            userSession.send(LoginEvent)
//            printThreadName("app")
//        }
//        println("End")

    }

    fun printThreadName(source: String) {
        println(source + " : " + Thread.currentThread().name)
    }

}

sealed class SessionEvent
object LoginEvent : SessionEvent()
object LogoutEvent : SessionEvent()