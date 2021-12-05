package me.ihainan

object P209 {
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    var ans = Int.MaxValue
    var left = 0
    var sum = 0
    nums.indices.foreach { right =>
      sum += nums(right)
      if (sum >= target) {
        while (sum >= target) {
          sum -= nums(left)
          left += 1
        }
        ans = ans.min(right - left + 2)
      }
    }
    if (ans == Int.MaxValue) 0 else ans
  }
}
