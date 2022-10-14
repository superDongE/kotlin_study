fun main(args: Array<String>) {

    val seq = generateSequence(2) {
        println("it : ${it}")
        if (it > 50) null else it * 3
    }

    println(seq.elementAt(0))
    println(seq.elementAt(1))
    println(seq.elementAt(2))
    println("Hello World")


    val list = listOf<Int>(1, 2, 3)
    val (x, y, z) = list

    println("x : $x, y : $y, z: $z")

    println("######")
    println(listOf(1, 2, 3, 4, 5).count() { it < 0 })

    println("######")
    val persons = sequenceOf(
        Person("Brook", "Hudson", 25),
        Person("Silver", "Watts", 30),
        Person("Dane", "Hall", 19),
        Person("Val", "Ortiz", 28)
    )

    println(persons.minWithOrNull(FULL_NAME_COMPARATOR))

}

class Person(
    val firstName: String,
    val familyName: String,
    val age: Int
) {
    override fun toString(): String = "$firstName $familyName : $age"
}

val Person.fullName get() = "$firstName $familyName"

val Person.reverseFullName get() = "$familyName $firstName"

val FULL_NAME_COMPARATOR = Comparator<Person> { p1, p2 ->
    println("p1 : ${p1.fullName}, p2 : ${p2.fullName}")
    p1.fullName.compareTo(p2.fullName)
}