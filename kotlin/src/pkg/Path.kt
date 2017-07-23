package pkg

import java.io.PrintWriter

/**
 * @author: Dmitry Tsydzik
 * @since: 23.07.2017.
 */
class Path(
        private val contour: List<Point>
) : Figure {
    override fun rotate(base: Point, angle: Double): Figure = Path(contour.map { it.rotate(base, angle) })

    override operator fun times(scale: Double): Figure = Path(contour.map { it * scale })

    override operator fun plus(delta: Point): Figure = Path(contour.map { it + delta })

    override fun mirrorX(x: Position): Figure = Path(contour.map { it.mirrorX(x) })

    override fun mirrorY(y: Position): Figure = Path(contour.map { it.mirrorY(y) })

    override fun render(pw: PrintWriter) {
        val midPart = contour.asSequence()
                .drop(1)
                .map { "L ${it.x} ${it.y}" }
                .joinToString(" ")

        val d = "M ${contour.first().x} ${contour.first().y} $midPart z"

        pw.println("""<path d="$d" fill="none" stroke="blue"/>""")
    }
}