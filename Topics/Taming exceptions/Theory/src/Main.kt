// You can experiment here, it won’t be checked

class LessThanZero : Exception("Parameter less than zero")
class GreaterThanTen : Exception("Parameter greater than ten")

open class MyException : ArithmeticException("My message")
class MySubclassException : MyException()

class MyCustomException : Exception {
    constructor() : super() // No parameters
    constructor(message: String?) : super(message) // Only the String parameter
    constructor(message: String?, cause: Throwable?) : super(message, cause) // Both parameters
    constructor(cause: Throwable?) : super(cause) // Only the Exception parameter
}

class MyArithmeticException : ArithmeticException {
    constructor() : super()
    constructor(message: String?) : super(message)
}

class BetweenOneAndFive : Exception("Value between 1 and 5")
class BetweenSixAndTen : Exception("Value between 6 and 10")

private const val TEN = 10
private const val THREE = 3
private const val FIVE = 5

fun myFunction(parameter: Int = -THREE) {
    val randomInteger = (1..TEN).shuffled().first() // Get a random integer between 1 and 10
    if (randomInteger <= FIVE) {
        throw BetweenOneAndFive()
    } else throw BetweenSixAndTen()
    /*
    if (parameter < 0) throw LessThanZero()
    else if (parameter > TEN) throw GreaterThanTen()
    */
}

fun testFunction(a: Int, b: Int): Int {
    return a / b
}

fun main(args: Array<String>) {
    // put your code here

    val otherException: Exception = Exception("other exception")

//    throw MyCustomException()
//    throw MyCustomException("My exception message")
//    throw MyCustomException("My exception message", otherException)
    throw MyCustomException(otherException)

    try {
        myFunction()
    } catch (e: BetweenOneAndFive) {
        println("BetweenOneAndFive was thrown")
    } catch (e: BetweenSixAndTen) {
        println("BetweenSixAndTen was thrown")
    }

//    myFunction(-THREE)

    try {
        testFunction(1, 0)
    } catch (e: Exception) {
//        throw Exception(e)
//        throw Exception("testFunction() failed", e)
        throw NullPointerException("NPE at Alpha point")
    }
}
