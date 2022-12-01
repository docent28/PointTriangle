import kotlin.math.pow
import kotlin.math.sqrt

class Point(xP: Double, yP: Double) {
    private val x = xP
    private val y = yP

    fun distance(other: Point): Double {
        return sqrt((x - other.x).pow(2) + (y - other.y).pow(2))
    }
}