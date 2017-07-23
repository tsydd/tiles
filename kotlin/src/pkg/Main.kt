package pkg

import java.io.File

/**
 * @author: Dmitry Tsydzik
 * @since: 21.07.2017.
 */
fun main(args: Array<String>) {
    File("out/test.svg").printWriter().use {
        it.xml {
            svg(
                    width = "32cm",
                    height = "55cm",
                    viewbox = "0 0 320 550") {
                flat.render(it)
                tiledArea(40, 20)
                        .mirrorY((B + D + F) / 2)
                        .render(it)
            }
        }
    }
}
