// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    // put your code here
//    var name: String = null.toString()
    var name: String? = null
//    println(name.length)
//    println(name!!.length)
    println(name?.length)
    println(name?.length ?: 545454)

    name?.let { println(it.length) }

    if (name != null) {
        println(name.length)
    }

//    name = "Kotlin"
    val length: Int = name?.length
        ?: 999 // throw Exception("The name is null")

    println(length)
}
