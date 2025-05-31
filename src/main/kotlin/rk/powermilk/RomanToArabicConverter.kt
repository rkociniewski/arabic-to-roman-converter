package rk.powermilk


@Suppress("MagicNumber")
private val romanToArabic = mapOf(
    "M" to 1000,
    "CM" to 900,
    "D" to 500,
    "CD" to 400,
    "C" to 100,
    "XC" to 90,
    "L" to 50,
    "XL" to 40,
    "X" to 10,
    "IX" to 9,
    "V" to 5,
    "IV" to 4,
    "I" to 1
)

/**
 * Converts this [String] representing a Roman numeral to its Arabic integer equivalent.
 *
 * The function is case-insensitive and ignores invalid trailing characters.
 * Returns 0 for invalid or empty input.
 *
 * @return An [Int] corresponding to the Arabic value of the Roman numeral.
 */
fun String.toArabic(): Int {
    var i = 0
    var result = 0
    val upper = this.uppercase()

    while (i < upper.length) {
        val two = if (i + 1 < upper.length) upper.substring(i, i + 2) else null
        val one = upper.substring(i, i + 1)

        when {
            two != null && romanToArabic.containsKey(two) -> {
                result += romanToArabic[two]!!
                i += 2
            }

            romanToArabic.containsKey(one) -> {
                result += romanToArabic[one]!!
                i += 1
            }

            else -> break // invalid character — early exit or skip
        }
    }

    return result
}
