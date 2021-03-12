package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime
import kotlin.math.pow


internal class FunctionsManualTest {


    private fun functionWithComma(
        number: Int,
        exponent: Int, //  <-- can be :)
    ): Double {

        return number.toDouble().pow(exponent)
    }


    @Test
    fun functionWithCommaTest() {
        val res = functionWithComma(number = 10, exponent = 2)
        assertEquals(res, 100.0)
    }


    /**
     * Funkce tiskne string na obrazovku
     * @author Roman Mikula
     * @since 2020-01-01
     * @param str skjdflskdjf
     * @param off offset. Default is 0
     * @param len Length of string
     */
    fun printString(str: String, off: Int = 0, len: Int = str.length) {
        println("Delka retezce $str je $len")
    }


    @ParameterizedTest
    @ValueSource(strings = ["Hello", "Doly", "Jak", "se", "mas"])
    fun defaultArgumentTest(parameters: String) {
        printString(str = parameters)
    }


    private fun foo(
        bar: Int = 0,
        baz: Int = 1,
        qux: (a: Int, b: Int) -> Unit
    ) {
        qux(bar, baz)
    }

    @Test
    fun functionWithLambdaTest() {
        foo(1) { a, b -> println("hello value: $a, value2: $b") }     // Uses the default value baz = 1
        foo(qux = { a, b -> println("hello2 value: $a, value2: $b") }) // Uses both default values bar = 0 and baz = 1
        foo { a, b -> println("hello3 value: $a, value2: $b") }        // Uses both default values bar = 0 and baz = 1
    }


    private fun foo(vararg strings: String) {
        strings.forEach {
            println(it)
        }
    }

    @Test
    fun varargsTest() {
        foo(strings = arrayOf("lskdjfsald", "sdlkjhfskljf", "slkdfjsaldfj"))
    }

    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }

    @Test
    fun asListTest() {

        val abc = asList(10, 20, 30)
        val bbb = intArrayOf(10, 20, 30)

        val bcd = asList(LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now())
        val cde = asList(LocalDate.now(), LocalDate.now(), LocalDate.now())
        val def = asList(ZonedDateTime.now(), ZonedDateTime.now(), ZonedDateTime.now())

        println(bcd)
        println(cde)
        println(def)
    }

    // Single-expression functions
    fun double(x: Int) = x * 2

    // Infix functions
    infix fun Int.myshl(x: Int): Int {
        println("Input $this and $x")
        return x * this
    }

    @Test
    fun infixFuncTest() {
        val res = 1 myshl 20
        println("Result $res")
    }

}