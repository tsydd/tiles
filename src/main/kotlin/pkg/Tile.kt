package pkg

/**
 * @author: Dmitry Tsydzik
 * @since: 23.07.2017.
 */

val RADIUS = 10.0 / Math.sin(Math.PI / 3)
const val INTERVAL = 0.4

val tile = hexagon * RADIUS

fun tiledArea(rows: Int, cols: Int): Group {
    val a = RADIUS * Math.sin(Math.PI / 3)
    val dx = (a * 2 + INTERVAL) * Math.sin(Math.PI / 3)
    val dy = (a * 2 + INTERVAL) * Math.cos(Math.PI / 3)

    val tiles = (0..cols).flatMap { numX ->
        val offsetX = dx * numX
        (0..rows).map { numY ->
            var offsetY = dy * 2 * numY
            if (numX % 2 == 1) {
                offsetY += dy
            }
            tile + (offsetX to offsetY)
        }
    }.toList()
    return Group(tiles)
}