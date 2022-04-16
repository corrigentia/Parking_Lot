fun reverse(input: Int?): Int {
//    return input?.toString()?.split("")?.dropLast(1)?.drop(1)?.reversed()?.joinToString("")?.toInt() ?: -1
    return input?.toString()?.reversed()?.toInt() ?: -1
}
