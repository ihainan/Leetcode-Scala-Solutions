package me.ihainan

object P1833 {
  def maxIceCream(costs: Array[Int], coins: Int): Int = {
    val dp = new Array[Int](coins + 1)
    costs.foreach { cost =>
      (coins to cost by -1).foreach { amount =>
        dp(amount) = dp(amount).max(dp(amount - cost) + 1)
      }
    }
    dp.max
  }
}