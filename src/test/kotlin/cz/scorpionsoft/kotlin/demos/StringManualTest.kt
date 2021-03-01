package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StringManualTest {

    @Test
    fun concatenateString() {
        val res = "Hello" + " world"
        assertEquals("Hello world", res)
    }

    @Test
    fun stringElements() {
        for (c in "Jak se máme,\n\tco děláme.") {
            print(c)
        }
    }

    @Test
    fun rawString() {
        val rawString = """
            lskdjfsalkjdfl
                ldsakjfsaldkjfldsj
            ldskjfsaldfkjsaf
            sdfjslfdlsa
            end.
            """.trimIndent()

        val rawString2 = """
            |lkjdlfkjasdlkjf 
            |Hello world
            |   sldfkjsadlkfjsa
            |   lkjldskjfaslkd
            |   3432 ldkjfldsa k\t\tl kjsadlfkj a\t
            |   end.
            |/
        """.trimMargin()

        println(rawString)
        println()
        println(rawString2)
    }

    @Test
    fun stringTemplates() {
        val i = 10
        println("i = $i") // prints "i = 10"

        val s = "abc"
        println("$s.length is ${s.length}") // prints "abc.length is 3"

        val price = """
            ${'$'}9.99
            """.trimIndent()
        println(price)
    }

    @Test
    fun stringTemplates2() {
        val msg = "Hello world!"

        println("Msg: $msg, length: ${msg.length}")
    }
}