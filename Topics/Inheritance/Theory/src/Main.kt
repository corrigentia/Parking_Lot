import kotlin.math.roundToInt

// You can experiment here, it won’t be checked

fun getFurnitureInfo(furniture: Furniture): String {
    return "furniture info: " + furniture.getFullInfo()
}

open class Furniture(val cost: Int) {
    open fun getFullInfo(): String = "$$cost cost"

//    override fun getTax(): String = "$${(cost * 0.25).roundToInt()} tax"
}

/*

override fun getFullFurnitureInfo(furniture: Furniture): String {
    return "furniture info: " + furniture.getFullInfo() + furniture.getTax()
}
*/

private const val QUARTER = 0.25

class Transport(private val cost: Int) {
    fun getFullInfo(): String {
        return "$$cost cost"
    }

    fun getTax(): String {
        return "$${(cost * QUARTER).roundToInt()} tax"
    }
}

/*

class Ship(cost: Int, private val color: String) : Transport(cost) {
    */
/*override fun getFullInfo(): String {
        return super.getFullInfo() + ", $color color"
    }*//*

}
*/

fun getTransportInfo(transport: Transport): String {
    return "transport info: " + transport.getFullInfo()
}

private const val THOUSAND = 1000
private const val TWO_THOUSAND = 2000

fun main(args: Array<String>) {
    // put your code here
    class BerryHolder(val weight: Int) {
        override fun toString(): String {
//            return super.toString()
            return weight.toString()
        }
    }

    val raspberryWeight = BerryHolder(10)
    val strawberryWeight = BerryHolder(15)
    val blueberryWeight = BerryHolder(20)

    println(raspberryWeight) // BerryHolder@6f496d9f
    println(strawberryWeight) // BerryHolder@723279cf
    println(blueberryWeight) // BerryHolder@10f87f48

    open class User(val id: Int, val login: String, val email: String) {
        override fun toString(): String {
            return "User{id=$id, login=$login, email=$email}"
        }
    }

    class Author(id: Int, login: String, email: String, val books: String): User(id, login, email) {
        override fun toString(): String {
//            return super.toString()
//            return "Author{id=$id, login=$login, email=$email}, books: $books"
//            return super.toString() + ", books: $books"
            return "Author: ${super.toString()};\nBooks: $books"
        }
    }

//    val user = User(1, "uncle_bob", "rmartin@objectmentor.com")
    val user = User(1, "marys01", "mary0101@gmail.com")
//    val author = Author(2, "srafael", "rsabatini@gmail.com", "Captain Blood: His Odyssey")
    val author = Author(2, "ohwilde", "wilde1854@mail.ie", "Someone’s portrait")


//    println(user) // User{id=1, login=uncle_bob, email=rmartin@objectmentor.com}
    println(user)   // User{id=1, login=marys01, email=mary0101@gmail.com}
    println(author) // User{id=2, login=srafael, email=rsabatini@gmail.com}

    val author1 = Author(1, "uncle_bob",
        "rmartin@objectmentor.com",
        "\n1.\"Clean Code: A Handbook of Agile Software Craftsmanship\" \n2.\"Agile Software Development: Principles, Patterns and Practices\"")
    val author2 = Author(2, "ltlst",
        "leotolstoy@mail.com",
        "\n1.\"Anna Karenina\" \n2.\"The Death of Ivan Ilyich\" \n3.\"War and Peace\"")

    println(author1)
    println()
    println(author2)

    val transport = Transport(THOUSAND)
//    val ship = Ship(TWO_THOUSAND, "marine")
    println(getTransportInfo(transport))
//    println(getTransportInfo(ship))
    println(transport.getTax())
//    println(ship.getTax())
}
