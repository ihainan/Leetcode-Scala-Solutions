package me.ihainan

object P1838 {
  def maxFrequency(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    var ans = 0
    var i = sorted.length - 1
    while (i >= 0) {
      var count = 1
      while (i >= 1 && sorted(i) == sorted(i - 1)) {
        count += 1
        i -= 1
      }
      var j = i - 1
      var kk = k
      while (j >= 0 && sorted(i) - sorted(j) <= kk) {
        kk -= sorted(i) - sorted(j)
        count += 1
        j -= 1
      }
      ans = ans.max(count)
      i -= 1
    }
    ans
  }
}