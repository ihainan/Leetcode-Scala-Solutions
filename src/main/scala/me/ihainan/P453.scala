package me.ihainan

object P453 {
  def minMoves(nums: Array[Int]): Int = {
    val sorted = nums.sorted.reverse
    var ans = 0
    (0 until sorted.length - 1).foreach { i =>
      if (sorted(i) != sorted(i + 1)) {
        ans += (i + 1) * (sorted(i) - sorted(i + 1))
      }
    }
    ans
  }
}
