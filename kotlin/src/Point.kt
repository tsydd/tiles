/**
 * @author: Dmitry Tsydzik
 * @since: 22.07.2017.
 */
typealias Position = Double

data class Point(
        val x: Position,
        val y: Position
) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())
}

operator fun Point.plus(point: Point) =
        Point(
                x = x + point.x,
                y = y + point.y
        )

operator fun Point.times(scale: Position) =
        Point(
                x = x * scale,
                y = y * scale
        )

fun Double.toPoint() =
        Point(
                x = Math.cos(this),
                y = Math.sin(this)
        )
