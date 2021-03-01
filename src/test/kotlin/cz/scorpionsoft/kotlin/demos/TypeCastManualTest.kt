package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Test


internal class TypeCastManualTest {

    @Test
    fun testCasting() {

        val a: Any = 30

        // ----- throws exception
        // val b = a as String

        // save casting
        val saveCast = a as? String

        println(saveCast)
    }
}