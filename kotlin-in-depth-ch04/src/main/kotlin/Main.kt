import java.io.File

val textFiled by lazy {
    File("data.txt").readText()
}

fun main(args: Array<String>) {

    val person = Person("hae dong", "LIM")
    val wallet = person.Possession("Wallet") // Possession 생성자 호출
    wallet.showOwner()


    val person2 = Person2("haedong", "LIM")
    println(person2.fullName)


    while (true) {
        when (val command = readLine() ?: return) {
            "print data" -> println(textFiled)
            "exit" -> return
        }
    }



/*    val person = Person("Hae Dong", "Lim")
    person.showMe()
    person1.showMe()*/
}

class Person(
    val firstName: String,
    val familyName: String,
) {

    inner class Possession(
        val description: String,
    ) {
        fun showOwner() = println(fullName())
    }

    private fun fullName() = "$firstName $familyName"
}

class Person2(val firstName : String, val familyName : String) {
    val fullName : String
    get() : String = "$firstName $familyName"
}


/*
class Person(val _firstName: String, val _familyName: String) {

    init {
        this.firstName = "firstName"
        this.familyName = "_familyName"
        println("init launced !!!")
    }

     constructor(_firstName: String, _familyName: String) {
         println("constructor launced!!!")
         this.firstName = firstName
         this.familyName = familyName
     }

    fun showMe() {

        println("firstName : $_firstName, familyName : $_familyName, ")
    }

}*/
