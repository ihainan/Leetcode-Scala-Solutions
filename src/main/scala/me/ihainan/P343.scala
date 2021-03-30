package me.ihainan

object P343 {
  def integerBreak(n: Int): Int = {
    val dp = new Array[Int](n + 1)
    var max = 0
    dp(0) = 1
    (1 until n).foreach { i =>
      (i to n).foreach { j =>
        dp(j) = dp(j).max(dp(j - i) * i)
        max = max.max(dp(j))
      }
    }
    max
  }
}