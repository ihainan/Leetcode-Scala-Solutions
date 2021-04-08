package me.ihainan

object O63 {
  def maxProfit(prices: Array[Int]): Int = {
    var ans = 0
    var min = Int.MaxValue
    prices.foreach { price =>
      if (price > min) ans = ans.max(price - min)
      else min = min.min(price)
    }
    ans
  }
}