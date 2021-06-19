package me.ihainan

object P486Solution4 {
  def PredictTheWinner(nums: Array[Int]): Boolean = {
    val len = nums.length
    val dp = Array.fill(len)(Int.MinValue)

    nums.indices.foreach { i => dp(i) = nums(i) }

    (len - 2 to 0 by -1).foreach { i =>
      (i + 1 until len).foreach { j =>
        dp(j) = (nums(i) - dp(j)).max(nums(j) - dp(j - 1))
      }
    }

    dp(len - 1) >= 0
  }
}