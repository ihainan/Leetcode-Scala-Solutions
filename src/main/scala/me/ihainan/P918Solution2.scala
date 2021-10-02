package me.ihainan

object P918Solution2 {
  def maxSubarraySumCircular(nums: Array[Int]): Int = {
    var (min, max) = (Int.MaxValue, Int.MinValue)
    var (minSum, maxSum, sum) = (0, 0, 0)

    nums.foreach { num =>
      sum += num
      minSum = num.min(minSum + num)
      maxSum = num.max(maxSum + num)
      min = min.min(minSum)
      max = max.max(maxSum)
    }

    if (min == sum) max
    else max.max(sum - min)
  }
}
