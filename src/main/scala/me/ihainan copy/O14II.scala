package me.ihainan

object O14II {
  def cuttingRope(n: Int): Int = {
    val dp = Array.fill(n + 1)(BigInt(0))
    val modNum = BigInt(1000000007)
    dp(0) = 1
    (1 until n).foreach { i =>
      (i to n).foreach { j =>
        dp(j) = dp(j).max(dp(j - i) * i)
      }
    }
    (dp(n) % modNum).toInt
  }
}