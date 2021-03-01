package cz.scorpionsoft.kotlin.demos

data class Person(val name: String, val  age: Int) {

    operator fun unaryPlus() = Person(name = name, age = age + 1)
}

operator fun Person.unaryMinus() = Person(name = name, age = age - 1)
