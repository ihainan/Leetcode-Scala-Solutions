package me.ihainan

object P1893 {
  def isCovered(ranges: Array[Array[Int]], left: Int, right: Int): Boolean = {
    val diff = new Array[Int](52)
    ranges.foreach { range =>
      diff(range(0)) += 1
      diff(range(1) + 1) -= 1
    }

    var current = 0
    (0 to right).foreach { i =>
      current += diff(i)
      if (i >= left && current <= 0) return false
    }

    true
  }
}