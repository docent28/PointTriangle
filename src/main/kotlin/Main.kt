fun main() {

    println(
        "При вводе координат можно использовать цифры, знак минус, десятичную" +
                " точку и десятичную запятую"
    )
    println()

    var arrCoordinates: Array<Double> = enteringCoordinatesTriangle("первой")
    val topA = Point(arrCoordinates[0], arrCoordinates[1])
    println("")

    arrCoordinates = enteringCoordinatesTriangle("второй")
    val topB = Point(arrCoordinates[0], arrCoordinates[1])
    println("")

    arrCoordinates = enteringCoordinatesTriangle("третьей")
    val topC = Point(arrCoordinates[0], arrCoordinates[1])
    println("")

    arrCoordinates = enteringCoordinatesPoint()
    val pOther = Point(arrCoordinates[0], arrCoordinates[1])

    val triangle = Triangle(topA, topB, topC)
    if (triangle.containsPoint(pOther)) {
        println("Точка находится ВНУТРИ треугольника")
    } else {
        println("Точка находится ВНЕ треугольника")
    }

}

fun enteringCoordinatesTriangle(orderPoint: String): Array<Double> {
    val arrCoord = arrayOf(0.0, 0.0)
    var temp = true
    var x0 = ""
    var y0 = ""
    println("Введите координаты $orderPoint вершины треугольника")
    while (temp) {
        print("   Введите координату X $orderPoint вершины треугольника - ")
        x0 = readln()
        if (isPosOrNegNumber(x0)) {
            temp = false
        }
    }
    temp = true
    while (temp) {
        print("   Введите координату Y $orderPoint вершины треугольника - ")
        y0 = readln()
        if (isPosOrNegNumber(y0)) {
            temp = false
        }
    }

    arrCoord[0] = x0.replace(",", ".").toDouble()
    arrCoord[1] = y0.replace(",", ".").toDouble()
    return arrCoord
}

fun enteringCoordinatesPoint(): Array<Double> {
    val arrCoord = arrayOf(0.0, 0.0)
    println("Введите координаты для точки")
    var temp = true
    var x0 = ""
    var y0 = ""
    while (temp) {
        print("   Введите координату X для точки - ")
        x0 = readln()
        if (isPosOrNegNumber(x0)) {
            temp = false
        }
    }
    temp = true
    while (temp) {
        print("   Введите координату Y для точки - ")
        y0 = readln()
        if (isPosOrNegNumber(y0)) {
            temp = false
        }
    }
    arrCoord[0] = x0.replace(",", ".").toDouble()
    arrCoord[1] = y0.replace(",", ".").toDouble()
    return arrCoord
}

fun isPosOrNegNumber(s: String?): Boolean {
    val regex = """^(-)?[0-9]*(([.,])[0-9]+)?$""".toRegex()
    return if (s.isNullOrEmpty()) false
    else regex.matches(s)
}
