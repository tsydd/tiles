package pkg

import java.io.File

const val RADUIS = 20.0
const val INTERVAL = 0.0

/**
 * <code>
 * 0----- A ------1
 * |              |
 * |              B
 * |              |
 * |      3-- C --2
 * |      |
 * |      D
 * |      |
 * |      4-- E --5
 * |              |
 * |              F
 * |              |
 * +--------------6
 * </code>
 */
const val A = 300.0
const val B = 200.0
const val C = 200.0
const val D = 150.0
const val E = C
const val F = 200.0

val flatContour: List<Point> = listOf(
        ZERO, // 0
        A to 0.0, // 1
        A to B, // 2
        (A - C) to B, // 3
        (A - C) to (B + D), // 4
        (A - C + E) to (B + D), // 5
        (A - C + E) to (B + D + F), // 6
        0.0 to (B + D + F) // 7
)

/**
 * @author: Dmitry Tsydzik
 * @since: 21.07.2017.
 */
fun main(args: Array<String>) {
    File("out/test.svg").printWriter().use {
        it.xml {
            svg(
                    width = "6cm",
                    height = "5cm",
                    viewbox = "0 0 600 500") {
                tileWithHexagons(
                        ZERO,
                        RADUIS,
                        INTERVAL,
                        10,
                        10
                )
                path(flatContour
                        .map { it.mirrorX(A / 2) }
                        .map { it.rotate(ZERO, -Math.PI / 6) }
                )
            }
        }
    }
}
