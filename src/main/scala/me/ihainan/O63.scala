package me.ihainan

object O63 {
  def maxProfit(prices: Array[Int]): Int = {
    var (min, ans) = (Int.MaxValue, 0)
    prices.foreach { price =>
      if (price > min) ans = ans.max(price - min)
      else min = price
    }
    ans
  }
}
