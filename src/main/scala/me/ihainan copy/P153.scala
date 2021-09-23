package me.ihainan

object P153 {
  def findMin(nums: Array[Int]): Int = {
    var (l, r) = (0, nums.length - 1)
    while (l < r) {
      val mid = (l + r) >>> 1
      if (nums(mid) > nums(r)) l = mid + 1
      else r = mid
    }
    nums(l)
  }
}