package me.ihainan

object P1984 {
  def minimumDifference(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    var ans = Int.MaxValue
    (k - 1 until sorted.length).foreach { s =>
      ans = ans.min(sorted(s) - sorted(s - k + 1))
    }
    ans
  }
}
