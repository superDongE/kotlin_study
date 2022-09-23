import kotlin.math.PI

fun circleArea(radius: Double): Double {

    return PI * radius * radius
}

fun increment(a: IntArray): Int {

    return ++a[0]
}

/**
 * same function
 */

/*fun prompt(name : String) {
    println(" ###### Hello, $name! ######")
}

fun prompt(name : String) : Unit {
    println(" ###### Hello, $name! ######")
}*/

fun change(vararg items: IntArray) {

    println(items.contentToString())
    items[0][0] = 100
}

fun main(args: Array<String>) {

/*    println("Enter radius : ")
    val radius = readLine()!!.toDouble() // input value
    println("Circle area : ${circleArea(radius)}")*/

/*    val a = intArrayOf(1, 2, 3)
    println(increment(a))
    println(a.contentToString())*/

    val a = intArrayOf(1, 2, 3)
    val b = intArrayOf(4, 5, 6)
    change(a, b)
    println(a.contentToString())
    println(b.contentToString())


/*    val number = readLine()!!.toInt()
    println("number : ${number !in 10 .. 99}") // input : true*/

    val c = IntArray(10) {
        println("val c $it") // 인덱스를 반환해서 동작한다.
        it
    }

    printSort(6, 2, 3, 4, 5, 0, 1)
    val d = intArrayOf(1, 5, 4, 3, 2)
    printSort(*d)
    println(d.contentToString())
    printSort(*d, *intArrayOf(6, 4, 5, 0, 1))
}

fun printSort(vararg items: Int) {
    items.sort()
    println(items.contentToString())
}