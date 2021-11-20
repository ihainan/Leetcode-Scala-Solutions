package me.ihainan

object P391Solution2 {
  def isRectangleCover(rectangles: Array[Array[Int]]): Boolean = {
    val count = collection.mutable.Map.empty[(Int, Int), Int].withDefaultValue(0)
    var (minX, minY, maxX, maxY) = (Int.MaxValue, Int.MaxValue, Int.MinValue, Int.MinValue)
    var area = 0

    rectangles.foreach { case Array(x1, y1, x2, y2) =>
      count((x1, y1)) += 1
      count((x2, y2)) += 1
      count((x1, y2)) += 1
      count((x2, y1)) += 1
      area += (y2 - y1) * (x2 - x1)
      minX = minX.min(x1)
      minY = minY.min(y1)
      maxX = maxX.max(x2)
      maxY = maxY.max(y2)
    }

    if ((maxY - minY) * (maxX - minX) != area) return false
    if (count.exists { case (_, v) => v != 1 && v != 2 && v != 4 }) return false
    if (count.count { case (_, v) => v == 1 } != 4) return false
    count((minX, minY)) == 1 && count((minX, maxY)) == 1 && count((maxX, minY)) == 1 && count((maxX, maxY)) == 1
  }
}