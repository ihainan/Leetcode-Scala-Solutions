package me.ihainan

object P198 {
  def rob(nums: Array[Int]): Int = {
    if (nums.length == 0) 0
    else {
      var (dp0, dp1, ans) = (0, nums(0), nums(0))
      (1 until nums.length).foreach { i =>
        val tmp = dp0
        dp0 = dp1.max(dp0)
        dp1 = tmp + nums(i)
        ans = ans.max(dp0).max(dp1)
      }
      ans
    }
  }
}