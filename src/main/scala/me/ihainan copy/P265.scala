package me.ihainan

object P265 {
  def minCostII(costs: Array[Array[Int]]): Int = {
    val (n, k) = (costs.length, costs.head.length)
    val dp = costs.head.map(x => x)
    (1 until n).foreach { i =>
      val tmp = dp.map(x => x)
      (0 until k).foreach { j =>
        dp(j) = (0 until k).withFilter(_ != j).map(l => tmp(l)).min + costs(i)(j)
      }
    }
    dp.min
  }
}