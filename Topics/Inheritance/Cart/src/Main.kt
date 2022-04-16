data class Product(val price: Int)

var productTax: Double = 0.0
private const val LAPTOP_TAX = 0.19
private const val TV_TAX = 0.17
private const val SMARTPHONE_TAX = 0.15
private const val HEADPHONES_TAX = 0.11

fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product(price)
    productTax = when (productType) {
        "headphones" -> HEADPHONES_TAX
        "smartphone" -> SMARTPHONE_TAX
        "tv" -> TV_TAX
        else -> LAPTOP_TAX
    }
    println(totalPrice(product))
}

fun totalPrice(product: Product): Int {
    return (product.price + product.price * productTax).toInt()
}
