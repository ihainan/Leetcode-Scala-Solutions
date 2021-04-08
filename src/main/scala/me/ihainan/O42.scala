package me.ihainan

object O42 {
  def maxSubArray(nums: Array[Int]): Int = {
    var ans = Int.MinValue
    var sum = 0
    nums.foreach { num =>
      if (sum >= 0) sum += num
      else sum = num
      ans = ans.max(sum)
    }
    ans
  }
}