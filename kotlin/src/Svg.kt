import java.io.PrintWriter

/**
 * @author: Dmitry Tsydzik
 * @since: 21.07.2017.
 */

typealias Position = Double

data class Point(
        val x: Position,
        val y: Position
) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())
}

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

fun PrintWriter.path(vararg points: Point) {
    val midPart = points.asSequence()
            .drop(1)
            .map { "L ${it.x} ${it.y}" }
            .joinToString(" ")

    val d = "M ${points.first().x} ${points.first().y} $midPart z"

    println("""<path d="$d" fill="red" stroke="blue"/>""")
}
