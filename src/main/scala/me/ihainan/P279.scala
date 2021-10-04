package me.ihainan

object P279 {
  def numSquares(n: Int): Int = {
    val dp = Array.fill(n + 1)(Int.MaxValue)
    dp(0) = 0
    (1 to (math.sqrt(n).toInt + 1)).foreach { i =>
      val ii = i * i
      (ii to n).foreach { j =>
        dp(j) = dp(j).min(dp(j - ii) + 1)
      }
    }
    dp(n)
  }
}
