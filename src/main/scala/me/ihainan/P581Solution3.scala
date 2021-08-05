package me.ihainan

object P581Solution3 {
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    var (l, r) = (nums.length, -1)
    var (min, max) = (Int.MaxValue, Int.MinValue)
    (nums.length - 1 to 0 by -1).foreach { i =>
      if (nums(i) <= min) min = nums(i)
      else l = i
      if (nums(nums.length - i - 1) >= max) max = nums(nums.length - i - 1)
      else r = nums.length - i - 1
    }
    if (l == nums.length) 0 else r - l + 1
  }
}