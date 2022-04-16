fun main() {
    val number = readLine()!!.toInt()
    println(round(number) ?: 0)
}

// do not change function below

private const val THOUSAND = 1000

fun round(number: Int): Int? {
    return if (number >= THOUSAND) null else number
}
