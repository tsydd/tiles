import java.io.File

const val RADUIS = 20.0
const val INTERVAL = 0
val A = RADUIS * Math.sin(Math.PI / 3)
val DX = (A * 2 + INTERVAL) * Math.sin(Math.PI / 3)
val DY = (A * 2 + INTERVAL) * Math.cos(Math.PI / 3)

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
                (0..10).forEach { numY ->
                    val offsetY = DY * 2 * numY
                    (0..10).forEach { numX ->
                        val offsetX = DX * 2 * numX
                        hexagon(
                                Point(offsetX, offsetY),
                                RADUIS
                        )
                    }
                }
            }
        }
    }
}
