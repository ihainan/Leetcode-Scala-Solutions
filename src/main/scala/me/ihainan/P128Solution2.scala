package me.ihainan

object P128Solution2 {
  def longestConsecutive(nums: Array[Int]): Int = {
    val set = nums.toSet
    var ans = 0
    nums.foreach { num =>
      if (!set(num - 1)) {
        var i = num
        while (set(i)) i += 1
        ans = ans.max(i - num)
      }
    }
    ans
  }
}