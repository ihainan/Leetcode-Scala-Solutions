package me.ihainan

object P714 {
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    var (dp0, dp1) = (0, -prices.head)
    (1 until prices.length).foreach { i =>
      val t0 = dp0 max (dp1 + prices(i) - fee)
      val t1 = dp1 max (dp0 - prices(i))
      dp0 = t0
      dp1 = t1
    }
    dp0 max dp1
  }
}
