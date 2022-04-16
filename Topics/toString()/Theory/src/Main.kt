// You can experiment here, it won’t be checked

data class Client(val name: String, val age: Int, val gender: String) {
    var balance: Int = 0

    override fun toString(): String {
        return "Client(name=$name, age=$age, gender=$gender, balance=$balance)"
    }
}

class ClientTedious(val name: String, val age: Int, val gender: String) {
    override fun equals(other: Any?): Boolean {
        if (this == other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (age != other.age) return false
        if (gender != other.gender) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        result = 31 * result + gender.hashCode()
        return result
    }
}

data class Customer(val name: String, val email: String)

fun main(args: Array<String>) {
    // put your code here
    val bob = Client("Bob", 29, "Male")
//    val john = bob.copy("John")
    val john = bob.copy(name = "John")
    println(bob)
    println(john)
}
