package me.ihainan

object P581Solution3 {
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    var (min, max) = (Int.MaxValue, Int.MinValue)
    var (left, right) = (-1, -1)
    (nums.length - 1 to 0 by -1).foreach { i =>
      if (nums(i) > min) left = i
      min = min.min(nums(i))
      if (nums(nums.length - i - 1) < max) right = nums.length - i - 1
      max = max.max(nums(nums.length - i - 1))
    }
  }
}