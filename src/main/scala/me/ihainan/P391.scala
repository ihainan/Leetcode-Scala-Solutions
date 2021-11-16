package me.ihainan

object P391 {
  def isOverlaped(r1: Array[Int], r2: Array[Int]): Boolean = {
    r1(0).max(r2(0)) < r1(2).min(r2(2)) &&
    r1(1).max(r2(1)) < r1(3).min(r2(3))
  }

  def isRectangleCover(rectangles: Array[Array[Int]]): Boolean = {
    val len = rectangles.length
    var area = 0
    var (minX, minY, maxX, maxY) =
      (rectangles(0)(0), rectangles(0)(1), rectangles(0)(2), rectangles(0)(3))
    (0 until len).foreach { i =>
      (i + 1 until len).foreach { j =>
        if (isOverlaped(rectangles(i), rectangles(j))) {
          return false
        }
      }
      area += (rectangles(i)(2) - rectangles(i)(0)) * (rectangles(i)(
        3
      ) - rectangles(i)(1))
      minX = minX.min(rectangles(i)(0))
      minY = minY.min(rectangles(i)(1))
      maxX = maxX.max(rectangles(i)(2))
      maxY = maxY.max(rectangles(i)(3))
    }

    (maxY - minY) * (maxX - minX) == area
  }
}
