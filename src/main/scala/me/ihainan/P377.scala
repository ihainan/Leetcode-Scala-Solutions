package me.ihainan

object P377 {
  def combinationSum4(nums: Array[Int], target: Int): Int = {
    val dp = new Array[Int](target + 1)
    dp(0) = 1
    (1 to target).foreach { t =>
      nums.foreach { num =>
        if (num <= t) {
          dp(t) += dp(t - num)
        }
      }
    }
    dp(target)
  }
}
