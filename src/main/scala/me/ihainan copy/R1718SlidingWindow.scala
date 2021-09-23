package me.ihainan

import scala.collection.mutable.Map

object R1718SlidingWindow {
  def shortestSeq(big: Array[Int], small: Array[Int]): Array[Int] = {
    val set = small.toSet
    var (l, r) = (0, 0)
    var min = Int.MaxValue
    val ans = Array(-1, -1)
    val map = Map.empty[Int, Int].withDefaultValue(0)
    big.indices.foreach { r =>
      if (set(big(r))) map(big(r)) = map(big(r)) + 1
      while (map.size == set.size) {
        if (min > r - l + 1) {
          min = r - l + 1
          ans(0) = l
          ans(1) = r
        }
        if (set(big(l))) {
          map(big(l)) = map(big(l)) - 1
          if (map(big(l)) == 0) map -= big(l)
        }
        l += 1
      }
    }
    if (ans(0) == -1) Array()
    else ans
  }
}