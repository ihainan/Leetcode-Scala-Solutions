package me.ihainan

object P518 {
  def change(amount: Int, coins: Array[Int]): Int = {
    val dp = Array.fill(amount + 1)(0)
    dp(0) = 1
    coins.foreach { c =>
      (c to amount).foreach { v =>
        dp(v) += dp(v - c)
      }
    }
    dp(amount)
  }
}
