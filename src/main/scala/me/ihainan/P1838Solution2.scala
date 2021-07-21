package me.ihainan

object P1838Solution2 {
  def maxFrequency(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    var (i, j, ans) = (0, 1, 1)
    var diff = 0
    while (j < sorted.length) {
      diff += (sorted(j) - sorted(j - 1)) * (j - i)
      while (i <= j && diff > k) {
        diff -= sorted(j) - sorted(i)
        i += 1
      }
      ans = ans.max(j - i + 1)
      j += 1
    }
    ans
  }
}