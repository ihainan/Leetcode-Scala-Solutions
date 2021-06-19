package me.ihainan

object P486Solution3 {
  def PredictTheWinner(nums: Array[Int]): Boolean = {
    val len = nums.length
    val dp = Array.fill(len, len)(Int.MinValue)

    nums.indices.foreach { i => dp(i)(i) = nums(i) }

    (len - 2 to 0 by -1).foreach { i =>
      (i + 1 until len).foreach { j =>
        dp(i)(j) = (nums(i) - dp(i + 1)(j)).max(nums(j) - dp(i)(j - 1))
      }
    }

    dp(0)(len - 1) >= 0
  }
}