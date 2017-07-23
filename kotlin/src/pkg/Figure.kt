package pkg

import java.io.PrintWriter

interface Figure {
    fun rotate(base: Point,
               angle: Double): Figure

    operator fun times(scale: Double): Figure

    operator fun plus(delta: Point): Figure

    fun render(pw: PrintWriter)

    fun mirrorX(x: Position): Figure

    fun mirrorY(y: Position): Figure
}