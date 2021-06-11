package me.ihainan

object P279 {
  def numSquares(n: Int): Int = {
    val nums = (1 to 100).map(num => num * num)
    val dp = Array.fill(n + 1)(Int.MaxValue)
    nums.indices.foreach { i =>
      val num = nums(i)
      (num to n).foreach { j =>
        if (j == num) dp(j) = 1
        else if (dp(j - num) >= 1 && dp(j - num) + 1 < dp(j)) dp(j) = dp(j - num) + 1
      }
    }
    dp(n)
  }
}