fun main() {


    val squares = IntArray(10) {
        println("it : $it")

        (it + 1) * (it + 1)
    }

    val numberList = squares
    numberList[1] = 100

}