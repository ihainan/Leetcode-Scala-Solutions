package me.ihainan

object P188 {
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    if (prices.length == 0 || k == 0) return 0
    var dp0 = new Array[Int](k + 1)
    var dp1 = Array.fill(k + 1)(-prices.head)
    (1 until prices.length).foreach { i =>
      val t0 = dp0.map(v => v)
      val t1 = dp1.map(v => v)
      (0 to k).foreach { j =>
        if (j >= 1) t0(j) = dp0(j) max (dp1(j - 1)) + prices(i)
        t1(j) = dp1(j) max (dp0(j) - prices(i))
      }
      dp0 = t0
      dp1 = t1
    }
    dp0.max max dp1.max
  }
}
