package me.ihainan

object P581Solution2 {
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    var (l, r) = (nums.length, -1)
    var (min, max) = (Int.MaxValue, Int.MinValue)
    (nums.length - 1 to 0 by -1).foreach { i =>
      if (nums(i) <= min) min = nums(i)
      else l = i
    }
    nums.indices.foreach { i =>
      if (nums(i) >= max) max = nums(i)
      else r = i
    }
    if (l == nums.length) 0 else r - l + 1
  }
}