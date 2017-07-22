import java.io.PrintWriter

/**
 * @author: Dmitry Tsydzik
 * @since: 21.07.2017.
 */

fun PrintWriter.xml(body: PrintWriter.() -> Unit) {
    println("""<?xml version="1.0" standalone="no"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN"
        "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">""")
    body()
}

fun PrintWriter.svg(width: String,
                    height: String,
                    viewbox: String,
                    body: PrintWriter.() -> Unit) {
    println("""<svg width="$width" height="$height" viewBox="$viewbox"
     xmlns="http://www.w3.org/2000/svg" version="1.1">""")
    body()
    println("""</svg>""")
}

fun PrintWriter.path(points: Sequence<Point>) {
    val midPart = points.asSequence()
            .drop(1)
            .map { "L ${it.x} ${it.y}" }
            .joinToString(" ")

    val d = "M ${points.first().x} ${points.first().y} $midPart z"

    println("""<path d="$d" fill="red" stroke="blue"/>""")
}

fun PrintWriter.path(vararg points: Point) {
    path(points.asSequence())
}

fun PrintWriter.hexagon(center: Point,
                        radius: Position,
                        rotate: Double = 0.0) {
    val points = generateSequence(rotate) { it + Math.PI / 3 }
            .map { it.toPoint() * radius + center }
            .take(6)

    path(points)
}

fun PrintWriter.tileWithHexagons(offset: Point,
                                 radius: Position,
                                 interval: Position,
                                 rows: Int,
                                 cols: Int) {
    val a = radius * Math.sin(Math.PI / 3)
    val dx = (a * 2 + interval) * Math.sin(Math.PI / 3)
    val dy = (a * 2 + interval) * Math.cos(Math.PI / 3)

    (0..cols).forEach { numY ->
        val offsetY = dy * 2 * numY + offset.y
        (0..rows).forEach { numX ->
            val offsetX = dx * 2 * numX + offset.x
            hexagon(
                    Point(offsetX, offsetY),
                    radius
            )
        }
    }
}