package me.ihainan

object P302 {
  def minArea(image: Array[Array[Char]], x: Int, y: Int): Int = {
    var (minX, minY, maxX, maxY) = (Int.MaxValue, Int.MaxValue, Int.MinValue, Int.MinValue)
    image.indices.foreach { i =>
      image.head.indices.foreach { j =>
        if (image(i)(j) == '1') {
          minX = minX.min(i)
          maxX = maxX.max(i)
          minY = minY.min(j)
          maxY = maxY.max(j)
        }
      }
    }

    if (minX == Int.MaxValue) 0
    else (maxY - minY + 1) * (maxX - minX + 1)
  }
}