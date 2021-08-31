package me.ihainan

object P322 {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp = Array.fill(amount + 1)(Int.MaxValue)
    dp(0) = 0
    coins.foreach { c =>
      (c to amount).foreach { v =>
        if (dp(v - c) != Int.MaxValue) {
          dp(v) = dp(v).min(dp(v - c) + 1)
        }
      }
    }
    if (dp(amount) == Int.MaxValue) -1 else dp(amount)
  }
}
