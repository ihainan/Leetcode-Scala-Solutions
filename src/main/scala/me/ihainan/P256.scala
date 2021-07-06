package me.ihainan

object P256 {
  def minCost(costs: Array[Array[Int]]): Int = {
    var (dp0, dp1, dp2) = (costs(0)(0), costs(0)(1), costs(0)(2))
    (1 until costs.length).foreach { i =>
      val tmp1 = costs(i)(0) + dp1.min(dp2)
      val tmp2 = costs(i)(1) + dp0.min(dp2)
      val tmp3 = costs(i)(2) + dp0.min(dp1)
      dp0 = tmp1
      dp1 = tmp2
      dp2 = tmp3
    }
    dp0.min(dp1).min(dp2)
  }
}