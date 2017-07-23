package pkg

import java.io.PrintWriter

/**
 * @author: Dmitry Tsydzik
 * @since: 23.07.2017.
 */
class Group(
        private val figures: List<Figure>
) : Figure {
    override fun rotate(base: Point, angle: Double): Figure = Group(figures.map { it.rotate(base, angle) })

    override fun times(scale: Double): Figure = Group(figures.map { it * scale })

    override fun plus(delta: Point): Figure = Group(figures.map { it + delta })

    override fun mirrorX(x: Position): Figure = Group(figures.map { it.mirrorX(x) })

    override fun mirrorY(y: Position): Figure = Group(figures.map { it.mirrorY(y) })

    override fun render(pw: PrintWriter) = figures.forEach { it.render(pw) }
}