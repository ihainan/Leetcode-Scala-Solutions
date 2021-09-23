package me.ihainan

object P300 {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val dp = Array.fill(nums.length)(1)
    var max = 0
    nums.indices.foreach { i =>
      (0 until i).foreach { j =>
        if (nums(i) > nums(j) && dp(j) + 1 > dp(i)) dp(i) = dp(j) + 1
      }
      max = max.max(dp(i))
    }
    max
  }
}