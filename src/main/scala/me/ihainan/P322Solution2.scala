package me.ihainan

object P322Solution2 {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp = Array.fill(coins.length + 1, amount + 1)(Int.MaxValue)
    dp.indices.foreach(i => dp(i)(0) = 0)

    (1 to coins.length).foreach { i =>
      val coin = coins(i - 1)
      (coin to amount).foreach { j =>
        (0 to i).foreach { k =>
          if (dp(k)(j - coin) != Int.MaxValue) {
            dp(i)(j) = dp(i)(j).min(dp(k)(j - coin) + 1)
          }
        }
      }
    }

    val min = dp.indices.map(i => dp(i)(amount)).min
    if (min == Int.MaxValue) -1 else min
  }
}
