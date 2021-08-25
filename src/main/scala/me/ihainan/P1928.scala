package me.ihainan

object P1928 {
  def minCost(maxTime: Int, edges: Array[Array[Int]], passingFees: Array[Int]): Int = {
    val n = passingFees.length
    val dp = Array.fill(maxTime + 1, n)(Int.MaxValue)
    dp(0)(0) = passingFees(0)
    var ans = dp(0)(n - 1)

    (1 to maxTime).foreach { t =>
      edges.foreach { case Array(c1, c2, time) =>
        if (t >= time) {
          val (f1, f2) = (passingFees(c1), passingFees(c2))
          if (dp(t - time)(c1) != Int.MaxValue) dp(t)(c2) = dp(t)(c2).min(dp(t - time)(c1) + f2)
          if (dp(t - time)(c2) != Int.MaxValue) dp(t)(c1) = dp(t)(c1).min(dp(t - time)(c2) + f1)
        }
      }
      ans = ans.min(dp(t)(n - 1))
    }

    if (ans != Int.MaxValue) ans else -1
  }
}