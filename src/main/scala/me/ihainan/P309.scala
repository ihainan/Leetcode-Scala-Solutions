package me.ihainan

object P309 {
  def maxProfit(prices: Array[Int]): Int = {
    var (a, b, c) = (0, 0, -prices.head)
    (1 until prices.length).foreach { i =>
      val t1 = c + prices(i)
      val t2 = a.max(b)
      val t3 = c.max(b - prices(i))
      a = t1
      b = t2
      c = t3
    }
    a max b max c
  }
}
