package rk.powermilk

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ArabicToRomanConverterTest {
    @ParameterizedTest
    @MethodSource("arabicToRomanProvider")
    fun `should convert arabic number to roman number`(input: Int, expected: String) =
        assertEquals(expected, input.toRoman())

    @Test
    fun `should convert arabic number to roman number for set`() =
        assertContentEquals(arabicToRoman.values, arabicToRoman.keys.toRoman())

    @Test
    fun `should convert arabic number to roman number for list`() =
        assertContentEquals(arabicToRoman.values, arabicToRoman.keys.toList().toRoman())

    @Test
    fun `should return empty string for zero and negative numbers`() {
        assertEquals("", 0.toRoman())
        assertEquals("", (-1).toRoman())
        assertEquals("", (-100).toRoman())
    }

    @Test
    fun `should convert largest valid roman number`() {
        assertEquals("MMMCMXCIX", 3999.toRoman())
    }

    @Test
    fun `should remove duplicates when converting list to roman`() {
        val input = listOf(5, 5, 10, 1)
        val expected = listOf("V", "X", "I")
        assertContentEquals(expected, input.toRoman())
    }

    @Test
    fun `should return empty list when input list or set is empty`() {
        assertContentEquals(emptyList(), emptySet<Int>().toRoman())
        assertContentEquals(emptyList(), emptyList<Int>().toRoman())
    }

    private val arabicToRoman = mapOf(
        1 to "I",
        2 to "II",
        3 to "III",
        4 to "IV",
        5 to "V",
        6 to "VI",
        7 to "VII",
        8 to "VIII",
        9 to "IX",
        10 to "X",
        11 to "XI",
        12 to "XII",
        13 to "XIII",
        20 to "XX",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M",
        846 to "DCCCXLVI",
        1999 to "MCMXCIX",
        2008 to "MMVIII"
    )

    private fun arabicToRomanProvider() =
        arabicToRoman.map { Arguments.of(it.key, it.value) }
}
