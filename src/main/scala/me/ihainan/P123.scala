package me.ihainan

object P123 {
  def maxProfit(prices: Array[Int]): Int = {
    var dp0 = Array(0, 0, 0)
    var dp1 = Array(-prices.head, -prices.head, -prices.head)
    prices.indices.foreach { i =>
      val t0 = dp0.map(v => v)
      val t1 = dp1.map(v => v)
      t0(0) = dp0(0)
      t0(1) = dp0(1) max (dp1(0) + prices(i))
      t0(2) = dp0(2) max (dp1(1) + prices(i))
      t1(0) = dp1(0) max (dp0(0) - prices(i))
      t1(1) = dp1(1) max (dp0(1) - prices(i))
      t1(2) = dp1(2) max (dp0(2) - prices(i))
      dp0 = t0
      dp1 = t1
    }

    dp0.max.max(dp1.max)
  }
}
