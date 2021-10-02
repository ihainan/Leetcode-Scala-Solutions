package me.ihainan

object P918 {
  def maxSubarraySumCircular(nums: Array[Int]): Int = {
    // 1-interval sub-array
    var (sum, ans) = (0, Int.MinValue)
    nums.foreach { num =>
      sum = num.max(sum + num)
      ans = ans.max(sum)
    }

    // 2-interval sub-array
    // get right-max first
    var rightSum = 0
    val rightMax = new Array[Int](nums.length)
    (nums.length - 1 to 0 by -1).foreach { i =>
      rightSum += nums(i)
      if (i == nums.length - 1) rightMax(i) = rightSum else rightMax(i) = rightMax(i + 1) max rightSum
    }

    // left-sum + right-max
    var leftSum = 0
    (0 until nums.length - 2).foreach { i =>
      leftSum += nums(i)
      ans = ans.max(leftSum + rightMax(i + 2))
    }

    ans
  }
}