package me.ihainan

object P1004Solution3 {
  def longestOnes(nums: Array[Int], k: Int): Int = {
    var (l, count, ans) = (0, 0, 0)
    nums.indices.foreach { r =>
      if (nums(r) == 0) count += 1
      while (l <= r && count > k) {
        if (nums(l) == 0) count -= 1
        l += 1
      }
      ans = ans.max(r - l + 1)
    }
    ans
  }
}
