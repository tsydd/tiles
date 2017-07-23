package pkg

/**
 * @author: Dmitry Tsydzik
 * @since: 23.07.2017.
 */

/**
 * <code>
 * 0----- A ------1
 * |              |
 * |   entrance   B
 * |              |
 * |      3-- C --2
 * |      |
 * |      D
 * |      |
 * |      4-- E --5
 * |              |
 * |    kitchen   F
 * |              |
 * 7--------------6
 * </code>
 */
const val A = 320.0
const val B = 170.0
const val C = 230.0
const val D = 160.0
const val E = C
const val F = 220.0

val flat = Path(listOf(
        ZERO, // 0
        A to 0.0, // 1
        A to B, // 2
        (A - C) to B, // 3
        (A - C) to (B + D), // 4
        (A - C + E) to (B + D), // 5
        (A - C + E) to (B + D + F), // 6
        0.0 to (B + D + F) // 7
))