package me.ihainan

object O14II {
  def cuttingRope(n: Int): Int = {
    val dp = Array.fill(n + 1)(BigInt(0))
    (2 to n).foreach { i => // capacity
      (1 to i).foreach { j => // item
        val v1 = dp(i - j) * BigInt(j)
        val v2 = BigInt(j) * BigInt(i - j)
        dp(i) = dp(i).max(v1).max(v2)
      }
    }
    (dp(n) % 1000000007).toInt
  }
}