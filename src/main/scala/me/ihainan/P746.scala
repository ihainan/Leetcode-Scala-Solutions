package me.ihainan

object P746 {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    var (a, b) = (cost(0), cost(1))
    (2 until cost.length).foreach { i => 
      val tmp = a.min(b) + cost(i)
      a = b
      b = tmp
    }
    a.min(b)
  }
}