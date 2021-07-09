package me.ihainan

object P930Solution2 {
  def numSubarraysWithSum(nums: Array[Int], goal: Int): Int = {
    var (l1, l2, r) = (0, 0, 0)
    var (sum1, sum2) = (0, 0)
    var ans = 0
    while (r < nums.length) {
      sum1 += nums(r)
      sum2 += nums(r)
      while (l1 <= r && sum1 > goal) {
        sum1 -= nums(l1)
        l1 += 1
      }
      while (l2 <= r && sum2 >= goal) {
        sum2 -= nums(l2)
        l2 += 1
      }
      ans += l2 - l1
      r += 1
    }
    ans
  }
}