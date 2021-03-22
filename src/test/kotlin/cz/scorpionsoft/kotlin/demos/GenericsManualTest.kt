package cz.scorpionsoft.kotlin.demos

import org.junit.jupiter.api.Test

class GenericsManualTest {

    /**
     * The general rule is: when a type parameter T of a class C is declared out,
     * it may occur only in out -position in the members of C,
     * but in return C<Base> can safely be a supertype of C<Derived>.
     * @author Roman Mikula
     */
    interface Source<out T> {
        fun next(): T
    }


    fun demo(strs: Source<String>): Source<Any> {
        val objects: Source<Any> = strs
        return objects
    }

    class Abc(val xx: String) : Source<String> {
        override fun next(): String {
            return xx
        }
    }

    @Test
    fun invariantTest() {

        val xyz = Abc("Hello Roman")

        val xx = xyz.next()

        val res: Source<Any> = demo(strs = xyz)

        println(res)

    }

    interface Comparablee<in T> {
        operator fun compareTo(other: T): Int
    }

    fun demo(x: Comparablee<Number>) {

        val r = x.compareTo(1.0)
        println(r)

        val y: Comparablee<Double> = x
    }

    open class Animal

    open class Dog : Animal() {
        fun haf() {
            println("Haf")
        }
    }
    open class Cat : Animal()

    class Schnauzer : Dog() {
        fun hafhaf() {
            println("Hafhaf")
        }
    }


    interface Gizmo {
        fun match(subject: Cat): Dog
    }

    interface SubGizmo : Gizmo {
        override fun match(subject: Cat): Schnauzer
    }

    class SubGizmoClass : SubGizmo {
        override fun match(subject: Cat): Schnauzer {
            return Schnauzer()
        }

    }

    private fun createSubGizmo(): SubGizmo {
        return SubGizmoClass()
    }

    @Test
    fun testGismo() {

        val subGizmo = createSubGizmo()
        val superGizmo = subGizmo as Gizmo

        val dog = superGizmo.match(Cat())     // Inferred type is Dog
        val schnauzer = subGizmo.match(Cat()) // Inferred type is Schnauzer

        dog.haf()
        schnauzer.hafhaf()

        println(dog)
        println(schnauzer)

    }

    interface Group<T> {
        fun insert(item: T)
        fun fetch(): T
    }

    fun read(group: Group<out Dog>): Dog {
        println(group.fetch())
        return group.fetch()
    }

    fun write(group: Group<in Dog>) {
        group.insert(Dog())
    }


    class MyGroup : Group<Animal> {
        override fun insert(item: Animal) {
            println("Inserted ${item::class}")
        }

        override fun fetch(): Animal {
            return Animal()
        }
    }

    class MyDogGroup : Group<Dog> {
        override fun insert(item: Dog) {
            println("Inserted ${item::class}")
        }

        override fun fetch(): Dog {
            return Dog()
        }
    }

    class MySchnauzerGroup : Group<Schnauzer> {
        override fun insert(item: Schnauzer) {
            println("Inserted ${item::class}")
        }

        override fun fetch(): Schnauzer {
            return Schnauzer()
        }
    }


    // https://typealias.com/guides/ins-and-outs-of-generic-variance/
    // https://typealias.com/guides/illustrated-guide-covariance-contravariance/
    @Test
    fun testGroup() {

        val xx = MyGroup()
        val dg = MyDogGroup()
        val sh = MySchnauzerGroup()

        val res = read(sh)

        write(xx)

        println(res)
    }
}