package me.ihainan

object P343Solution2 {
  def integerBreak(n: Int): Int = {
    val dp = new Array[Int](n + 1)
    (2 to n).foreach { i => // capacity
      (1 to i).foreach { j => // item
        dp(i) = dp(i).max(dp(i - j) * j).max(j * (i - j))
      }
    }
    dp(n)
  }
}