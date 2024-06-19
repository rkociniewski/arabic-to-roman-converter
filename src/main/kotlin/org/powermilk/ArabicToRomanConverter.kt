package org.powermilk

private val romanNumberals = mapOf(
    1000 to "M",
    900 to "CM",
    500 to "D",
    400 to "CD",
    100 to "C",
    90 to "XC",
    50 to "L",
    40 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I"
)

/**
 * Function extension for converting [Int] to roman number.
 */
fun Int.toRoman(): String {
    for (i in romanNumberals.keys) {
        if (this >= i) {
            return romanNumberals[i] + (this - i).toRoman()
        }
    }
    return ""
}

/**
 * Function extension for converting [Int] to roman number (set).
 */
fun Set<Int>.toRoman() = map { it.toRoman() }

/**
 * Function extension for converting [Int] to roman number (list).
 */
fun List<Int>.toRoman() = toSet().map { it.toRoman() }
