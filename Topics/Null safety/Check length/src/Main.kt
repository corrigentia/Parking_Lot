fun main() {
    val argument = readLine()!!
    println(check(argument)?.length ?: 0)
}

// do not change function below

private const val FIVE = 5

fun check(name: String): String? {
    return if (name.length > FIVE) null else name
}
