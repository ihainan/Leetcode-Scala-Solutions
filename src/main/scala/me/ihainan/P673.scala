package me.ihainan

object P673 {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    val dp = Array.fill(nums.length)(1)
    val count = Array.fill(nums.length)(1)
    var max = 1
    nums.indices.foreach { i =>
      (0 until i).foreach { j =>
        if (nums(j) < nums(i)) {
          if (dp(i) < dp(j) + 1) {
            count(i) = count(j)
            dp(i) = dp(j) + 1
          } else if (dp(i) == dp(j) + 1) {
            count(i) += count(j)
          }
        }
      }
      max = max.max(dp(i))
    }

    dp.indices.filter(i => dp(i) == max).map(i => count(i)).sum
  }
}
