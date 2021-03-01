package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Test
import kotlin.math.pow

class ArraysManualTest {

    @Test
    fun arraysTest() {

        val a = arrayOf(1, 2, 3)

        val b = intArrayOf(1,2,3)

        val xx = Array<Int>(20) {
            it * it
        }

        xx.forEach {
            print("$it ")
        }

        val nullArr = arrayOfNulls<Int>(10)
        nullArr.fill(1)

        // ---------------------------------------------




        // --------------------------
        val c1 = IntArray(size = 20) {
            1 shl it
        }
        // --------------------------
        val d = doubleArrayOf(1.0, 2.0, 3.0)
        // --------------------------
        val e = byteArrayOf(12,3,4)
        // --------------------------
        val f = Array<Byte>(30) {
            var res = it.toByte()
            res
        }
        // --------------------------
        // --------------------------



        println(a)
        println(b)
        println(xx)
    }
}