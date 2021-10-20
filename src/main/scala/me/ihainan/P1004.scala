package me.ihainan

object P1004 {
  def longestOnes(nums: Array[Int], k: Int): Int = {
    val dp = new Array[Int](k + 1)
    var (ans, count) = (0, 0)
    nums.foreach { num =>
      if (num == 1) count += 1
      else {
        dp(0) = 0
        (k to 1 by -1).foreach(i => dp(i) = dp(i - 1) + 1 + count)
        count = 0
      }
      ans = ans.max(dp.last + count)
    }
    
    ans
  }
}