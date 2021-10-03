package me.ihainan

object P121 {
  def maxProfit(prices: Array[Int]): Int = {
    var ans = 0
    var min = prices.head
    (1 until prices.length).foreach { i =>
      if (prices(i) > min) ans = ans.max(prices(i) - min)
      else min = prices(i)
    }
    ans
  }
}
