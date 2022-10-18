fun main(args: Array<String>) {

    println("### chapter08 start ###")

    /* println(startAndStop(Car()))
     println(startAndStop(Boat()))*/

    /*val car = Car();
    car.start();
    //car.onStart() ### 이건 안됌 코틀린에서는 이렇게 상속 받을 수 없다고 함. 320p*/

    /*val vehicle: Vehicle = Car()
    vehicle.start()
    vehicle.stop()

    println(Car().start())
    println(Car().stop()) // Car is stopping 출력 가능*/

    //val truck = Truck()

    /*val student1 = Student("Euan", "Reynolds", 25, "MIT")
    val student2 = Student("Val Watts", 22, "ETHZ")

    println("student1 : ${student1.name}, ${student1.age}, ${student1.university}")
    println("student2 : ${student2.toString()}")*/

    /*val objects = arrayOf("1", 2, "3", 4, "5")
    var sum = 0

    for(obj in objects) {
        if(obj is Int) {
            sum += obj
        }
    }

    println("sum is $sum")*/

    /*// Bounds : 20.0*20.0, area : 314.1592653589793
    Circle(10.0).print()

    // Bounds : 3.0*5.0, area : 15.0
    Rectangle(3.0, 5.0).print()*/

    /*var aircraft = Aircraft()
    println("aircraft init ### currentSpeed is ${aircraft.currentSpeed}")
    aircraft.move()
    aircraft.stop()*/

    //Amphibia().move()

    Alias(Person("realIdentity", 27), Person("newIdenity", 28)).print()
}

interface PersonData {
    val name: String
    val age: Int
}

open class Person(
    override val name: String,
    override val age: Int
) : PersonData

class Alias(
    private val realIdentity: PersonData,
    private val newIdenity: PersonData
) : PersonData by newIdenity {
    override val age: Int
        get() = realIdentity.age

    fun print() {
        println("Alias realIdentity : $realIdentity, newIdenity : $newIdenity, age : $age")
    }
}


/*interface Car {
    fun move() {
        println("Car is move")
    }
}

interface Ship {
    fun move() {
        println("Ship is move")
    }
}

class Amphibia : Car, Ship {
    override fun move() {
        super<Car>.move()
        super<Ship>.move()
    }
}*/

/*interface Vehicle {
    val currentSpeed: Int
    fun move()
    fun stop()
}

class Aircraft : Vehicle {
    override var currentSpeed: Int = 0
        private set

    override fun move() {
        currentSpeed = 50
        println("Aircraft is moving ### currentSpeed is $currentSpeed")
    }

    override fun stop() {
        currentSpeed = -1
        println("Aircraft is stop ### currentSpeed is $currentSpeed")
    }
}*/

/*abstract class Shape {
    abstract val width: Double
    abstract val height: Double
    abstract fun area(): Double

    fun print() {
        println("Bounds : $width*$height, area : ${area()}")
    }
}

class Circle(private val radius: Double) : Shape() {
    private val diameter get() = 2 * radius

    override val width: Double
        get() = diameter
    override val height: Double
        get() = diameter

    override fun area(): Double {
        return PI * radius * radius
    }
}

class Rectangle(
    override val width: Double,
    override val height: Double
) : Shape() {
    override fun area(): Double = width * height
}*/

/*open class Person {
     val name : String
     val age : Int

    constructor(name : String, age : Int) {
        this.name = name
        this.age = age
    }

    constructor(firstName: String, familyName : String, age: Int) : this("$firstName $familyName", age) {

    }
}

class Student : Person {
     val university : String

    constructor(name: String, age: Int, university : String) : super(name, age) {
        this.university = university
    }

    constructor(
        firstName: String,
        familyName: String,
        age: Int,
        university: String
    ) : super(firstName, familyName, age) {
        this.university = university
    }
}*/

/*open class Vehicle {
    init {
        println("Vehicle is initialize!!!")
    }
}

open class Car : Vehicle() {
    init {
        println("Car is initialize!!!")
    }
}

class Truck : Car() {
    init {
        println("Truck is initialize!!!")
    }
}*/


/*open class Vehicle {
    open fun start() {
        println("I'm moving")
    }
}

fun Vehicle.stop() {
    println("Vehicle is stop")
}

class Car : Vehicle() {
    override fun start() {
        println("Car is moving")
    }
}

fun Car.stop() {
    println("Car is stopping")
}*/

/*open class Vehicle {
    protected open fun onStart() {}

    fun start() {
        println("Vehicle is start!!!")
    }
}

class Car : Vehicle() {
    override fun onStart() {
        println("Car is onStart!!!")
    }
}*/

/*fun startAndStop(vehicle: Vehicle) {
    vehicle.start()
    vehicle.stop()
}*/

/*
open class Vehicle {

    open fun start() { // open 으로 지정해야 하위 클래스에서 재정의가 가능합니다.
        println("moving")
    }

    fun stop() { // stop function is final!! because not open keyword not used!!
        println("stop!!!")
    }
}

class Car : Vehicle() {
    override fun start() {
        println("Car is moving")
    }
}

class Boat : Vehicle() {
    override fun start() {
        println("Boat is moving")
    }
}*/
