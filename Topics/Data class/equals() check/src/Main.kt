data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }
}

private const val THREE = 3

fun main() {
    // implement your code here
    val (name1, age1, balance1) = List(THREE) { readln() }
    val (name2, age2, balance2) = List(THREE) { readln() }
    val client1 = Client(name1, age1.toInt(), balance1.toInt())
    val client2 = Client(name2, age2.toInt(), balance2.toInt())
    println(client1 == client2)
}
