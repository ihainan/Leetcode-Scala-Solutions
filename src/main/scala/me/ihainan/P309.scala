package me.ihainan

object P309 {
  def maxProfit(prices: Array[Int]): Int = {
    var ans = 0
    var (dp0, dp1, dp2) = (0, 0, -prices.head)
    (1 until prices.length).foreach { i =>
      val t1 = dp2 + prices(i)
      val t2 = dp0 max dp1
      val t3 = dp2 max (dp1 - prices(i))
      dp0 = t1
      dp1 = t2
      dp2 = t3
    }

    dp0 max dp1 max dp2
  }
}
