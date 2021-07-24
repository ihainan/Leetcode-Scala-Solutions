package me.ihainan

object P1877 {
  def minPairSum(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var ans = 0
    var (i, j) = (0, sorted.length - 1)
    while (i < j) {
      ans = ans.max(sorted(i) + sorted(j))
      i += 1
      j -= 1
    }
    ans
  }
}