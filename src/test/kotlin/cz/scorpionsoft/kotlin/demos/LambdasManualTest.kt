package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Test
import java.util.ArrayList


typealias MyHandler = (event: Int, value: String) -> Unit

internal class LambdasManualTest {

    data class SomeData(val name: String, val value: Double)

    @Test
    fun foldTest() {

        val arr = intArrayOf(10, 20, 30, 40, 50, 34, 32, 32, 4)
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

        val resBuilder = arr.fold(StringBuilder(), { a, b ->
            a.append(b).append(",")
            a
        })

        println("Result: $resBuilder")

        val times = arr.fold(1.0, Double::times)
        println("Result: $times")
    }

    @Test
    fun functionTypes() {
        val xx: () -> String = {
            "Hello"
        }

        println(xx())
    }

    /**
     * Function type is nullable
     * @param cnt sdf
     * @param predicate xdf
     */
    fun doItSecond(cnt: Int, predicate: ((a: Int, b: Int) -> Int)?) {
        for (i in 1..cnt) {
            val res: Int? = predicate?.invoke(i, i)
        }
    }

    fun doItXTimes(cnt: Int, handler: MyHandler) {

        for (i in 1..cnt) {
            handler(i, i.toString())
        }
    }

    private fun handlerAsFunction(event: Int, value: String) {
        println("Dělám to $event a $value")
    }

    @Test
    fun testDoIt() {

        doItXTimes(cnt = 20) { event, value ->
            println("Dělám to $event a $value")
        }

        // put function
        doItXTimes(10, this::handlerAsFunction)
    }

    fun myPrint(expression: () -> Unit) {
        expression()
    }

    @Test
    fun tryMyPrint() {
        myPrint { println("Hello world") }
    }

    // it: implicit name of a single parameter
    fun myPrint2(expression: (String) -> Unit) {
        expression("Pass some string value")
    }

    /**
     * it: implicit name of a single parameter
     */
    @Test
    fun tryMyPrint2() {

        // it: implicit name of a single parameter
        myPrint2 { println(it) }

        // named parameter
        myPrint2 { par -> println(par) }
    }


    @Test
    fun filtering() {

        val persList: List<Person> = listOf(Person("Roman", 10), Person("Marki", 20), Person("Martin", 30))

        val list: ArrayList<Int> = arrayListOf(10, 3, 234, 23, 3, 4, 10, 35, 23)
        val rest = list.filter { it > 15 }
            .foldIndexed(0) { idx, a, b ->
                println("Value in index: $idx is $b")
                a + b
            }

        println(rest)

        // persList.sortDescending()
        println(list)

        val res2 = list.groupBy { it }.map { it.value.sum() }
        val res3 = list.groupingBy { it }.fold(1) { a, b ->
            a * b
        }

        println(res2)
        println(res3)
    }

    @Test
    fun `Function literals with receiver`() {

        val sum: Int.(Int) -> Int = { other -> plus(other) }
        val sum2: Int.(Int) -> Int = { other -> this + other }

        val res = 10.sum(30)
        val res2 = 10.sum2(30)


        println("$res, $res2")
    }

}