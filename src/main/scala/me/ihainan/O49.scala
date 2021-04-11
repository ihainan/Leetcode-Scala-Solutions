package me.ihainan

object O49 {
  def nthUglyNumber(n: Int): Int = {
    val dp = new Array[Int](n)
    dp(0) = 1
    var (a, b, c) = (0, 0, 0)
    (1 until n).foreach { i =>
      val min = (dp(a) * 2).min(dp(b) * 3).min(dp(c) * 5)
      if (min == dp(a) * 2) a += 1
      if (min == dp(b) * 3) b += 1
      if (min == dp(c) * 5) c += 1
      dp(i) = min.toInt
    }
    dp(n - 1)
  }
}