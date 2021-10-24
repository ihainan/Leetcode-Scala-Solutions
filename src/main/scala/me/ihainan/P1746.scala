package me.ihainan

object P1746 {
  def maxSumAfterOperation(nums: Array[Int]): Int = {
    var (sum1, sum2, ans) = (0, 0, 0)
    nums.foreach { num =>
      val t1 = num.max(sum1 + num)
      val t2 = (num * num).max(sum1 + num * num).max(sum2 + num)
      sum1 = t1
      sum2 = t2
      ans = ans.max(sum1).max(sum2)
    }
    ans
  }
}
