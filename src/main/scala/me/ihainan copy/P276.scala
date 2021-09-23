package me.ihainan

object P276 {
  def numWays(n: Int, k: Int): Int = {
    val dp1 = Array.fill(k)(0)
    val dp2 = Array.fill(k)(0)
    (0 until k).foreach { j => dp1(j) = 1 }
    (1 until n).foreach { i =>
      val (tmp1, tmp2) = (dp1.map(x => x), dp2.map(x => x))
      val (sum1, sum2) = (tmp1.sum, tmp2.sum)
      (0 until k).foreach { j =>
        dp1(j) = sum1 + sum2 - tmp1(j) - tmp2(j)
        dp2(j) = tmp1(j)
      }
    }
    dp1.sum + dp2.sum
  }
}