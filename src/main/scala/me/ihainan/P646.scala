package me.ihainan

object P646 {
  def findLongestChain(pairs: Array[Array[Int]]): Int = {
    val dp = Array.fill(pairs.length)(1)
    val sorted = pairs.sortWith { case (p1, p2) =>
      if (p1(0) == p2(0)) p1(1) < p2(1)
      else p1(0) < p2(0)
    }

    (1 until sorted.length).foreach { i =>
      (0 until i).foreach { j =>
        if (sorted(i)(0) > sorted(j)(1)) {
          dp(i) = dp(i).max(dp(j) + 1)
        }
      }
    }

    dp.max
  }
}
