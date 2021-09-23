package me.ihainan

object P5854 {
  def minimumDifference(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted.reverse
    var ans = Int.MaxValue
    (0 to nums.length - k).foreach { i =>
      ans = ans.min(sorted(i) - sorted(i + k - 1))
    }
    ans
  }
}
