package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Test


internal class LambdasManualTest {

    data class SomeData(val name: String, val value: Double)

    @Test
    fun foldTest() {

        val arr = intArrayOf(10, 20, 30, 234, 234, 34, 32, 32, 4)
        val arr2 = arrayOf(
            SomeData(name = "Roman", value = 23.2),
            SomeData(name = "Roman2", value = 23.2),
            SomeData(name = "Roman3", value = 23.2),
            SomeData(name = "Roman4", value = 23.2),
        )

        val res2 = arr2.fold(
            0.0,
            { acc, item ->
                acc + item.value
            }
        )

        val res = arr.fold(0.0, { a, b ->
            println("Input values: $a, $b")
            a + b
        })

        println("Result: $res")
        println("Result: $res2")
    }

}