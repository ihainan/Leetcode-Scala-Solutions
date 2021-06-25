package me.ihainan

object P149 {
  def isInLine(x1: Int, y1: Int, x2: Int, y2: Int, x: Int, y: Int): Boolean = {
    (x1 - x) * (y2 - y) == (x2 - x) * (y1 - y)
  }

  def maxPoints(points: Array[Array[Int]]): Int = {
    var ans = 1
    points.indices.foreach { i =>
      val (x1, y1) = (points(i)(0), points(i)(1))
      (i + 1 until points.length).foreach { j =>
        val (x2, y2) = (points(j)(0), points(j)(1))
        if (x1 != x2 || y1 != y2) {
          var count = 0
          points.foreach { p3 =>
            val (x, y) = (p3(0), p3(1))
            if (isInLine(x1, y1, x2, y2, x, y)) count += 1
          }
          ans = ans.max(count)
        }
      }
    }
    ans
  }
}