package me.ihainan

object R1614 {
  def isInLine(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Boolean = {
    if ((x3 == x1 && y3 == y1) || (x3 == x2 && y3 == y2)) true
    else if (x1 == x2) x3 == x1
    else if (y1 == y2) y3 == y1
    else (x3 - x1) * 1.0 / (x2 - x1) == (y3 - y1) * 1.0 / (y2 - y1)
  }

  def bestLine(points: Array[Array[Int]]): Array[Int] = {
    var max = 0
    var ans = Array(Int.MaxValue, Int.MaxValue)

    points.indices.foreach { i =>
      val p1 = points(i)
      points.indices.foreach { j =>
        if (i != j) {
          val p2 = points(j)
          var count = 0
          points.indices.foreach { k =>
            val p3 = points(k)
            if (isInLine(p1(0), p1(1), p2(0), p2(1), p3(0), p3(1))) {
              count += 1
            }
          }

          if (count > max || (count == max && (ans(0) > i || (ans(0) == i && ans(1) > j)))) {
            max = count
            ans(0) = i
            ans(1) = j
          }
        }
      }
    }

    ans
  }
}