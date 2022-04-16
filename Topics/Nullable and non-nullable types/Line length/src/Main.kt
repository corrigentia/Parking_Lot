fun main() {
    val line: String? = readLine()
    // write your code here. Do not change line above
//    println(line.length) // need a fix
//    println(line?.length ?: -1) // need a fix
    if (line != null) {
        println(line.length)
    } else println(-1)
}
