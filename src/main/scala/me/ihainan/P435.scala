package me.ihainan

object P435 {
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    val sorted = intervals.sortWith { case (i1, i2) =>
      if (i1(1) != i2(1)) i1(1) < i2(1)
      else if (i1(0) != i2(0)) i1(0) > i2(0)
      else true
    }

    var ans = 0
    var (s, e) = (sorted(0)(0), sorted(0)(1))
    (1 until sorted.length).foreach { i =>
      if (sorted(i)(0) < e) {
        ans += 1
      } else {
        s = sorted(i)(0)
        e = sorted(i)(1)
      }
    }

    ans
  }
}
