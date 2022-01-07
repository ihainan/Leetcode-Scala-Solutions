package me.ihainan

object P128 {
  def longestConsecutive(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var current = 0
    var ans = 0
    sorted.indices.foreach { i =>
      if (i == 0) current = 1
      else if (sorted(i) == sorted(i - 1)) current = current
      else if (sorted(i) == sorted(i - 1) + 1) current += 1
      else current = 1
      ans = ans.max(current)
    }
    ans
  }
}
