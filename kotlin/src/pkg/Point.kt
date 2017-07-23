package pkg

/**
 * @author: Dmitry Tsydzik
 * @since: 22.07.2017.
 */
typealias Position = Double

typealias Point = Pair<Position, Position>

val Point.x: Position get() = first
val Point.y: Position get() = second

operator fun Point.plus(point: Point): Point
        = (x + point.x) to (y + point.y)

operator fun Point.times(scale: Position): Point
        = (x * scale) to (y * scale)

fun Double.toPoint(): Point
        = Math.cos(this) to Math.sin(this)

val ZERO: Point = 0.0 to 0.0

/**
 * https://academo.org/demos/rotation-about-point/
 */
fun Point.rotate(base: Point,
                 angle: Double): Point {
    val x0 = x - base.x
    val y0 = y - base.y
    val x1 = x0 * Math.cos(angle) - y0 * Math.sin(angle)
    val y1 = y0 * Math.cos(angle) + x0 * Math.sin(angle)
    return (base.x + x1) to (base.y + y1)
}

fun Point.mirrorX(x_: Position): Point = (x_ * 2 - x) to y

fun Point.mirrorY(y_: Position): Point = x to (y_ * 2 - y)