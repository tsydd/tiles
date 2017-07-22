import java.io.File

const val RADUIS = 20.0
const val INTERVAL = 0.0

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
                        Point(0, 0),
                        RADUIS,
                        INTERVAL,
                        10,
                        10
                )
            }
        }
    }
}
