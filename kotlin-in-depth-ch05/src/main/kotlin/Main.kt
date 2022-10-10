fun main(args: Array<String>) {

    val consum = StringConsumer { s -> println(s) }
    consum.accept("haedong")

    println(lessThan(4, 5))

    val loweCaseRoom = 'h'.isLowerCase()
    println(loweCaseRoom)

    println(check("Hello") { c -> c.isLetter() })
    println(check("Hello") { it.isLowerCase() })

    println("#######")

    println(indexOf(intArrayOf(4, 3, 2, 1)) {
        println("it is $it")
        it < 3
    })

    println("####")
    println("Hello".truncate(3))
}

fun String.truncate(maxLength: Int): String {
    return if (length <= maxLength) this@truncate else substring(0, maxLength)
}

inline fun indexOf(numbers: IntArray, condition: (Int) -> Boolean): Int {
    for (i in numbers.indices) {
        if (condition(numbers[i])) return i
    }

    return -1
}

fun interface StringConsumer {
    fun accept(s: String)
}

fun check(s: String, condition: (Char) -> Boolean): Boolean {
    for (c in s) {
        println("char c is : ${c}")
        if (!condition(c)) return false
    }

    return true
}

val lessThan = { a: Int, b: Int -> a < b }