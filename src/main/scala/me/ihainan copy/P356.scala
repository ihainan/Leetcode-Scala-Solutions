package me.ihainan

object P356 {
  def isReflected(points: Array[Array[Int]]): Boolean = {
    var (minX, maxX) = (Int.MaxValue, Int.MinValue)
    val set = collection.mutable.Set.empty[(Double, Double)]
    points.foreach { p =>
      val (x, y) = (p(0), p(1))
      minX = minX.min(x)
      maxX = maxX.max(x)
      set += ((x, y))
    }

    val cx = (minX + maxX) * 1.0 / 2
    set.filter { v => v._1 <= cx }.foreach { v =>
      val (x, y) = (v._1, v._2)
      val (rx, ry) = (2 * cx - x, y)
      if (!set((rx, ry))) return false
      else {
        set -= ((rx, ry))
        set -= ((x, y))
      }
    }

    set.isEmpty
  }
}