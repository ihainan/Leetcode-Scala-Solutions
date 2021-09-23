package me.ihainan

object R0811 {
  def waysToChange(n: Int): Int = {
    val coins = Array(25, 10, 5, 1)
    val dp = new Array[Int](n + 1)
    dp(0) = 1
    coins.foreach { coin =>
      (coin to n).foreach { sum =>
        if (dp(sum - coin) > 0) dp(sum) = (dp(sum) + dp(sum - coin)) % 1000000007
      }
    }
    dp(n)
  }
}