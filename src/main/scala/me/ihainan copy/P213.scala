package me.ihainan

object P213 {
  def rob(nums: Array[Int]): Int = {
    if (nums.length == 1) nums(0)
    else if (nums.length == 2) nums(0).max(nums(1))
    else rob(nums, 0, nums.length - 2).max(rob(nums, 1, nums.length - 1))
  }

  def rob(nums: Array[Int], start: Int, end: Int): Int = {
    var (dp0, dp1, ans) = (0, nums(start), nums(start))
    (start + 1 to end).foreach { i =>
      val tmp = dp0
      dp0 = dp0.max(dp1)
      dp1 = tmp + nums(i)
      ans = ans.max(dp0).max(dp1)
    }
    ans
  }
}