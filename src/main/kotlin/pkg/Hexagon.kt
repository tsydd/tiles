package pkg

/**
 * @author: Dmitry Tsydzik
 * @since: 23.07.2017.
 */
val hexagon = Path(
        generateSequence(0.0) { it + Math.PI / 3 }
                .map { it.toPoint() }
                .take(6)
                .toList()
)