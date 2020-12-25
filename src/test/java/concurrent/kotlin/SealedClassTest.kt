package concurrent.kotlin

import org.junit.jupiter.api.Test

class SealedClassTest {

    @Test
    fun test1() {
        fun printGender(gender: Gender) {
            when (gender) {
                is Female -> println("Female")
                is Male -> println("Male")
            }
        }
        printGender(Female)
        printGender(Male(dickSize = 15))
    }
}

sealed class Gender
data class Male(val dickSize: Int) : Gender()
object Female : Gender()
