package me.ihainan

object P53 {
  def maxSubArray(nums: Array[Int]): Int = {
    var (max, sum) = (Int.MinValue, 0)
    nums.foreach { num =>
      if (sum <= 0) sum = num
      else sum += num
      max = max.max(sum)
    }
    max
  }
}