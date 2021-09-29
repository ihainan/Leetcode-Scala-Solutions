package me.ihainan

object P45 {
  def jump(nums: Array[Int]): Int = {
    val dp = Array.fill(nums.length)(Int.MaxValue)
    dp(0) = 0
    nums.indices.foreach { i =>
      (i + 1 to (i + nums(i)).min(nums.length - 1)).foreach(j =>
        dp(j) = dp(j).min(dp(i) + 1)
      )
    }
    dp.last
  }
}
