package me.ihainan

object P1833Solution3 {
  def maxIceCream(costs: Array[Int], coins: Int): Int = {
    val max = costs.max
    val counts = new Array[Int](max + 1)
    costs.foreach { cost => counts(cost) += 1 }
    var amount = coins
    var ans = 0
    (1 to max).foreach { i =>
      while (counts(i) > 0) {
        if (i > amount) return ans
        else {
          ans += 1
          amount -= i
          counts(i) -= 1
        }
      }
    }
    ans
  }
}