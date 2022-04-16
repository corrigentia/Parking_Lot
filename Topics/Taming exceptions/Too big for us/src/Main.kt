fun returnValue(): Int {
    val value = readln().toInt()

    // write your code here
    if (value > 0) {
        throw ArithmeticException("It's too big")
    } else return value
}
