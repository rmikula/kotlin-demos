package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
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

}