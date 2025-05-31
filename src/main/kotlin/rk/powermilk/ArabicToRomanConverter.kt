package rk.powermilk

/**
 * Ordered list of Roman numeral mappings from highest to lowest value.
 *
 * Used to recursively convert Arabic integers to their Roman numeral representation.
 * Each pair consists of:
 * - An [Int] key: the Arabic numeral.
 * - A [String] value: the corresponding Roman numeral.
 *
 * The list must remain sorted in descending order to ensure correct conversion.
 */
@Suppress("MagicNumber")
private val romanNumerals = listOf(
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
 * Converts this [Int] value to its Roman numeral representation.
 *
 * Supports values from 1 upward.
 * Returns an empty string for 0 or negative numbers.
 *
 * @return A [String] containing the Roman numeral.
 */
fun Int.toRoman(): String {
    return when {
        this <= 0 -> ""
        else -> {
            val (value, numeral) = romanNumerals.first { this >= it.first }
            numeral + (this - value).toRoman()
        }
    }
}


/**
 * Converts each [Int] in this [Set] to its Roman numeral representation.
 *
 * @return A [List] of Roman numeral [String]s.
 */
fun Set<Int>.toRoman(): List<String> = map(Int::toRoman)

/**
 * Converts each [Int] in this [List] to its Roman numeral representation.
 *
 * Removes duplicates by converting to a [Set].
 * Original list order is not preserved.
 *
 * @return A [List] of Roman numeral [String]s.
 */
fun List<Int>.toRoman(): List<String> = toSet().toRoman()
