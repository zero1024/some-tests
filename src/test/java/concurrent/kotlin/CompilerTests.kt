package concurrent.kotlin

import org.junit.Test

class CompilerTests {

    @Test
    fun test1() {
        val customPrintln: (String) -> Unit = { println(it) }
        customPrintln("Hello!")
    }
}