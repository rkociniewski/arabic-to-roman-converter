package rk.powermilk

import kotlin.test.Test
import kotlin.test.assertEquals

internal class RomanToArabicConverterTest {

    private val romanToArabic = mapOf(
        "I" to 1,
        "II" to 2,
        "III" to 3,
        "IV" to 4,
        "V" to 5,
        "VI" to 6,
        "VII" to 7,
        "VIII" to 8,
        "IX" to 9,
        "X" to 10,
        "XI" to 11,
        "XII" to 12,
        "XIII" to 13,
        "XX" to 20,
        "XL" to 40,
        "L" to 50,
        "XC" to 90,
        "C" to 100,
        "CD" to 400,
        "D" to 500,
        "CM" to 900,
        "M" to 1000,
        "DCCCXLVI" to 846,
        "MCMXCIX" to 1999,
        "MMVIII" to 2008,
        "MMMCMXCIX" to 3999
    )

    @Test
    fun `should convert roman numeral to arabic number`() {
        for ((roman, arabic) in romanToArabic) {
            assertEquals(arabic, roman.toArabic(), "Expected $roman -> $arabic")
        }
    }

    @Test
    fun `should handle lowercase and mixed case`() {
        assertEquals(9, "ix".toArabic())
        assertEquals(2024, "MmXxIv".toArabic())
    }

    @Test
    fun `should return 0 for invalid or empty strings`() {
        assertEquals(0, "".toArabic())
        assertEquals(0, "ABC".toArabic())
    }
}
