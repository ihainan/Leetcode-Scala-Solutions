package me.ihainan

object P485 {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var (len, ans) = (0, 0)
    nums.foreach { num =>
      if (num == 1) len += 1 else len = 0
      ans = ans.max(len)
    }
    ans
  }
}
