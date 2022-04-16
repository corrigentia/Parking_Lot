package parking

private const val EMPTY_STRING = ""

var parkingLot = emptyArray<MutableMap<String, String>>()
var lotCreated = false
var noOccupiedSpots = true

private fun create(spots: Int) {
    parkingLot = Array(spots) {
        mutableMapOf(Pair("registration", EMPTY_STRING), Pair("color", EMPTY_STRING))
    }
    lotCreated = true
    noOccupiedSpots = true
    println("Created a parking lot with ${parkingLot.size} spots.")
}

private fun isParkingLotAbsent() = !lotCreated || parkingLot.isEmpty()

fun handleAbsentLot(function: () -> Unit) {
    if (isParkingLotAbsent()) {
        println("Sorry, a parking lot has not been created.")
    } else {
        function()
    }
}

fun handleEmptyLot(function: () -> Unit) {
    if (noOccupiedSpots) {
        println("Parking lot is empty.")
    } else {
        function()
    }
}

private fun regByColor(givenColor: String) {
    handleAbsentLot {
        handleEmptyLot {
            val carsWithColor = mutableListOf<String>()
            for (index in parkingLot.indices) {
                val car = parkingLot[index]
                if (car["color"]!!.lowercase() == givenColor.lowercase()) {
                    carsWithColor.add(car["registration"]!!)
                }
            }
            println(if (carsWithColor.isEmpty()) {
                "No cars with color $givenColor were found."
            } else carsWithColor.joinToString())
        }
    }
}

fun spotByGivenCriterion(criterion: String, given: String) {
    handleAbsentLot {
        handleEmptyLot {
            val spotsOfConformingCars = mutableListOf<Int>()
            for (index in parkingLot.indices) {
                if (parkingLot[index][criterion]!!.lowercase() == given.lowercase()) {
                    spotsOfConformingCars.add(index + 1)
                }
            }
            println(if (spotsOfConformingCars.isEmpty()) {
                "No cars with ${if (criterion == "color") criterion else "$criterion number"} $given were found."
            } else spotsOfConformingCars.joinToString())
        }
    }
}

private fun spotByReg(givenRegistrationNumber: String) {
    spotByGivenCriterion(criterion = "registration", givenRegistrationNumber)
}

private fun spotByColor(givenColor: String) {
    spotByGivenCriterion(criterion = "color", givenColor)
}

private fun status() {
    handleAbsentLot {

        if (noOccupiedSpots) {
            println("Parking lot is empty.")
        } else {

            for (index in parkingLot.indices) {
                if (parkingLot[index]["color"]!!.isNotEmpty()) {
                    print(index + 1)
                    for ((_, value) in parkingLot[index]) {
                        print(" $value")
                    }
                    println()
                }
            }
        }
    }
}

private fun leave(spotNumber: Int) {
    handleAbsentLot {

        val spotIndex = spotNumber - 1

        if (parkingLot[spotIndex]["color"]!!.isNotEmpty()) {
            parkingLot[spotIndex] = mutableMapOf(Pair("registration", EMPTY_STRING), Pair("color", EMPTY_STRING))
            println("Spot $spotNumber is free.")
        } else println("There is no car in spot $spotNumber.")
    }
}

private fun parkRegistrationColor(
    registrationColor: List<String>,
) {
    handleAbsentLot {

        var firstEmptyIndex = 0
        while (parkingLot[firstEmptyIndex]["color"]!!.isNotEmpty()) {
            if (++firstEmptyIndex > parkingLot.lastIndex) break
        }
        if (firstEmptyIndex < parkingLot.size) {

            parkingLot[firstEmptyIndex]["registration"] = registrationColor[1]
            parkingLot[firstEmptyIndex]["color"] = registrationColor[2]
            println("${parkingLot[firstEmptyIndex]["color"]} car parked in spot ${firstEmptyIndex + 1}.")
        } else println("Sorry, the parking lot is full.")
        noOccupiedSpots = false
    }
}

fun main() {
    do {
        val commandString = readLine()!!.split(" ")
        val command = commandString.first()
        when (command) {
            "exit" -> return
            "status" -> status()
            "park" -> parkRegistrationColor(commandString)
            "spot_by_color" -> spotByColor(commandString[1])
            "spot_by_reg" -> spotByReg(commandString[1])
            "reg_by_color" -> regByColor(commandString[1])
            "leave" -> leave(commandString[1].toInt())
            "create" -> create(commandString[1].toInt())
        }
    } while (command != "exit")
}
