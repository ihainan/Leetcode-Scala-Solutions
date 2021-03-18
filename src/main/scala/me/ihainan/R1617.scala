package me.ihainan

object R1617 {
  def maxSubArray(nums: Array[Int]): Int = {
    var dp = nums(0)
    var ans = dp
    (1 until nums.length).foreach { i =>
      dp = if (dp > 0) dp + nums(i) else nums(i)
      ans = ans.max(dp)
    }
    ans
  }
}