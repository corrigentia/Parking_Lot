    fun main() {
        val line = readLine()
            ?: error("No lines read.") // throw IllegalStateException("No lines read.") // you need to add something
        println("Elvis says: $line")
    }
