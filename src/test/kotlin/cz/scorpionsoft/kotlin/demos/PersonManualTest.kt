package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test



internal class PersonManualTest {

    @BeforeEach
    fun setUp() {
        println("SetUp")
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun helloWorld() {

        val one: Long = 1
        println(one)

        val p = Person(name = "RoMik", age = 30)
        println("Person: $p")

        assertEquals("RoMik", p.name)
    }

    @Test
    fun explicitConversion() {

        val b: Byte = 1 // OK, literals are checked statically
        // val i: Int = b // ERROR
        val i1: Int = b.toInt()
        val i2 = b.toLong()

        assertEquals(b, i2)
    }


}