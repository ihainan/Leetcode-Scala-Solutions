package me.ihainan

object P487 {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var (a, b, ans) = (0, 0, 0)
    nums.foreach { num =>
      if (num == 1) {
        a += 1
        b += 1
      } else {
        a = b + 1
        b = 0
      }
      ans = ans.max(a).max(b)
    }
    ans
  }
}