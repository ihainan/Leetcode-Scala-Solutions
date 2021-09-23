package me.ihainan

object O49 {
  def nthUglyNumber(n: Int): Int = {
    val dp = new Array[Int](n)
    dp(0) = 1
    var (x2, x3, x5) = (0, 0, 0)
    (1 until n).foreach { i =>
      val min = (dp(x2) * 2).min(dp(x3) * 3).min(dp(x5) * 5)
      if (min == dp(x2) * 2) x2 += 1
      if (min == dp(x3) * 3) x3 += 1
      if (min == dp(x5) * 5) x5 += 1
      dp(i) = min
    }
    dp(n - 1)
  }
}