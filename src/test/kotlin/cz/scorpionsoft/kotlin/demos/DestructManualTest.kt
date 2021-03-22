package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Test

data class Result(val result: Int, val status: String)

class DestructManualTest {

    inline fun destructTest(a: Int, b: String): Result {
        return Result(result = 10, status = "OK")
    }

    @Test
    fun testDestruct() {

        val (a, b) = destructTest(a = 10, b = "20.3")

        println("$a $b")
    }

    @Test
    fun testDestructMapInLoop() {

        val map = mapOf(1 to "RoMik", 2 to "Market", 3 to "Ufon")

        for (value in map) {
            println("${value.key}  ${value.value}")
        }

        val res = Pair(10, 20).toList()

        println(res)

    }

}