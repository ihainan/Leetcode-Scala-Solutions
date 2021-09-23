package me.ihainan

object P1099 {
  def twoSumLessThanK(nums: Array[Int], k: Int): Int = {
    var (i, j) = (0, nums.length - 1)
    val sorted = nums.sorted
    var ans = -1
    while (i < j) {
      if (sorted(i) + sorted(j) < k) {
        ans = ans.max(sorted(i) + sorted(j))
        i += 1
      } else j -= 1
    }
    ans
  }
}