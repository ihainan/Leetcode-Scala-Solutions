package me.ihainan

object R1716 {
  def massage(nums: Array[Int]): Int = {
    if (nums.length == 0) 0
    else {
      var dp0 = 0
      var dp1 = nums.head
      var ans = dp0 max dp1
      (1 until nums.length).foreach { i =>
        val tmp = dp0
        dp0 = dp0 max dp1
        dp1 = tmp + nums(i)
        ans = ans.max(dp0).max(dp1)
      }
      ans
    }
  }
}