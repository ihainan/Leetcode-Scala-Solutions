package me.ihainan

object P713 {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    var mul = 1
    var left = 0
    var ans = 0
    nums.indices.foreach { right =>
      mul *= nums(right)
      while (left <= right && mul >= k) {
        mul /= nums(left)
        left += 1
      }
      if (left <= right) {
        ans += right - left + 1
      }
    }
    ans
  }
}