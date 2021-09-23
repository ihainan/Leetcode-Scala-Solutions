package me.ihainan

object P1833Solution2 {
  def maxIceCream(costs: Array[Int], coins: Int): Int = {
    val sorted = costs.sorted
    var amount = coins
    var ans = 0
    sorted.foreach { cost =>
      if (amount >= cost) {
        amount -= cost
        ans += 1
      } else return ans
    }
    ans
  }
}