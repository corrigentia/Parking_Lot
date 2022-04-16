private const val MILLION = 1_000_000
private const val PALACE_COEFFICIENT = 1.6
private const val MANSION_COEFFICIENT = 1.4
private const val MANSION_MAX_ROOMS = 7
private const val MANSION_MIN_ROOMS = 5
private const val COTTAGE_COEFFICIENT = 1.25
private const val COTTAGE_ROOMS = 4
private const val BUNGALOW_COEFFICIENT = 1.2
private const val BUNGALOW_MAX_ROOMS = 3

data class House(val rooms: Int, val price: Int)

fun totalPrice(house: House): Int {
    val basePrice = when {
        house.price < 0 -> 0
        house.price > MILLION -> MILLION
        else -> house.price
    }

    val coefficient: Double = when {
        house.rooms <= 1 -> 1.0
        house.rooms == 2 || house.rooms == BUNGALOW_MAX_ROOMS -> BUNGALOW_COEFFICIENT
        house.rooms == COTTAGE_ROOMS -> COTTAGE_COEFFICIENT
        house.rooms in MANSION_MIN_ROOMS..MANSION_MAX_ROOMS -> MANSION_COEFFICIENT
        else -> PALACE_COEFFICIENT
    }

    return (basePrice * coefficient).toInt()
}

fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = House(rooms, price)
    println(totalPrice(house))
}
