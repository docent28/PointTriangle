import kotlin.math.sqrt

class Triangle(top_A: Point, top_B: Point, top_C: Point) {
    private val topA = top_A
    private val topB = top_B
    private val topC = top_C

    private fun perimeter(p1: Point, p2: Point, p3: Point): Double {
        return p1.distance(p2) + p1.distance(p3) + p2.distance(p3)
    }

    private fun areaHeron(p1: Point, p2: Point, p3: Point): Double {
        val semiPerimeter = perimeter(p1, p2, p3) / 2
        return sqrt(
            semiPerimeter * (semiPerimeter - p1.distance(p2)) *
                    (semiPerimeter - p1.distance(p3)) *
                    (semiPerimeter - p2.distance(p3))
        )
    }

    fun containsPoint(otherPoint: Point): Boolean {
        val areaOne = areaHeron(topA, topB, otherPoint)
        val areaTwo = areaHeron(topA, topC, otherPoint)
        val areaThree = areaHeron(topB, topC, otherPoint)
        val areaZero = areaHeron(topA, topB, topC)

        return (areaOne + areaTwo + areaThree) <= (areaZero + 0.01)
    }
}