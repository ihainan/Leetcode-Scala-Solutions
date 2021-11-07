package me.ihainan

object P416 {
  def canPartition(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    if (sum % 2 != 0) return false
    val half = sum / 2
    val dp = new Array[Boolean](half + 1)
    dp(0) = true
    nums.foreach { num =>
      (half to num by -1).foreach { v =>
        dp(v) = dp(v) | dp(v - num)
      }
      if (dp(half)) return true
    }
    false
  }
}
