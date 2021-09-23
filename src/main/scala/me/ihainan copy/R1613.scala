package me.ihainan

object R1613 {
  def intersection(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double, x4: Double, y4: Double): (Double, Double) = {
    // (x1, y1) - (x2, y2) is segment, (x3, y3) - (x4, y4) is line
    if (x3 == x4 && y3 == y4) {
      // two squares share the same center, so we use x = x3
      if (x1 == x2) (Double.MaxValue, Double.MaxValue)
      else (x3, y1)
    } else if (x3 == x4) {
      // line is parallel with y-axis, same as below
      if (x1 == x2) (Double.MaxValue, Double.MaxValue)
      else (x3, y1)
    } else if (y3 == y4) {
      // line is parallel with x-axis
      if (y1 == y2) (Double.MaxValue, Double.MaxValue)
      else (x1, y3)
    } else {
      val t = (x1 * (y4 - y3) - x3 * (y4 - y3) + y3 * (x4 - x3) - y1 * (x4 - x3)) * 1.0 / ((y2 - y1) * (x4 - x3) - (x2 - x1) * (y4 - y3))
      if (t < 0 || t > 1) (Double.MaxValue, Double.MaxValue)
      else (x1 + t * (x2 - x1), y1 + t * (y2 - y1))
    }
  }

  def cutSquares(square1: Array[Int], square2: Array[Int]): Array[Double] = {
    val (x1, y1, l1, x5, y5, l2) = (square1(0), square1(1), square1(2), square2(0), square2(1), square2(2))
    val (x2, y2, x3, y3, x4, y4) = (x1 + l1, y1, x1 + l1, y1 + l1, x1, y1 + l1)
    val (x6, y6, x7, y7, x8, y8) = (x5 + l2, y5, x5 + l2, y5 + l2, x5, y5 + l2)
    val (xc1, yc1, xc2, yc2) = (x1 + l1 * 1.0 / 2, y1 + l1 * 1.0 / 2, (x5 + x6) * 1.0 / 2, (y5 + y8) * 1.0 / 2)
    val list = collection.mutable.ListBuffer.empty[(Double, Double)]

    list += intersection(x1, y1, x2, y2, xc1, yc1, xc2, yc2)
    list += intersection(x2, y2, x3, y3, xc1, yc1, xc2, yc2)
    list += intersection(x3, y3, x4, y4, xc1, yc1, xc2, yc2)
    list += intersection(x4, y4, x1, y1, xc1, yc1, xc2, yc2)
    list += intersection(x5, y5, x6, y6, xc1, yc1, xc2, yc2)
    list += intersection(x6, y6, x7, y7, xc1, yc1, xc2, yc2)
    list += intersection(x7, y7, x8, y8, xc1, yc1, xc2, yc2)
    list += intersection(x8, y8, x5, y5, xc1, yc1, xc2, yc2)

    val points = list.filter(_._1 != Double.MaxValue)
    var distance = 0.0
    val ans = new Array[Double](4)
    points.indices.foreach { i =>
      points.indices.foreach { j =>
        if (i != j) {
          val p1 = points(i)
          val p2 = points(j)
          val d = (p2._2 - p1._2) * (p2._2 - p1._2) + (p2._1 - p1._1) * (p2._1 - p1._1)
          if (d > distance) {
            distance = d
            if (p1._1 < p2._1 || (p1._1 == p2._1 && p1._2 < p2._2)) {
              ans(0) = p1._1
              ans(1) = p1._2
              ans(2) = p2._1
              ans(3) = p2._2
            } else {
              ans(0) = p2._1
              ans(1) = p2._2
              ans(2) = p1._1
              ans(3) = p1._2
            }
          }
        }
      }
    }

    ans
  }
}