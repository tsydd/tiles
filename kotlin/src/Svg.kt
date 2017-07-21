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
