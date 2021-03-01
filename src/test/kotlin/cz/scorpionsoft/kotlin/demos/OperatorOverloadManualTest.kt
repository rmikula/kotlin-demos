package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Test



internal class OperatorOverloadManualTest {

    @Test
    fun unaryPlusTest() {

        val p = Person(name = "RoMik", age = 1)

        val p2 = +p

        val p3 = -p

        println(p2)
        println(p3)
    }
}