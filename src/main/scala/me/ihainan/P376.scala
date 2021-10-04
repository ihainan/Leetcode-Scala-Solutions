package me.ihainan

object P376 {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    val dp1 = Array.fill(nums.length)(1)
    val dp2 = Array.fill(nums.length)(1)
    var ans = 1
    (1 until nums.length).foreach { i =>
      (0 until i).foreach { j =>
        if (nums(i) > nums(j)) dp1(i) = dp1(i).max(dp2(j) + 1)
        if (nums(i) < nums(j)) dp2(i) = dp2(i).max(dp1(j) + 1)
      }
      ans = ans max dp1(i) max dp2(i)
    }
    ans
  }
}
