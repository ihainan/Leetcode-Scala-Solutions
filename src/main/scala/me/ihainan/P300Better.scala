package me.ihainan

object P300Better {
  def lengthOfLIS(nums: Array[Int]): Int = {

    val dp = new Array[Int](nums.length + 1)
    var len = 1
    dp(len) = nums(0)
    (1 until nums.length).foreach { i =>
      if (nums(i) > dp(len)) {
        len += 1
        dp(len) = nums(i)
      } else {
        val j = find(1, len, nums(i), dp)
        dp(j + 1) = nums(i)
      }
    }
    len
  }

  @scala.annotation.tailrec
  def find(l: Int, r: Int, num: Int, dp: Array[Int]): Int = {
    if (l > r) 0
    else if (dp(r) < num) r
    else {
      val mid = (l + r) >>> 1
      if (dp(mid) < num) find(mid, r - 1, num, dp)
      else find(l, mid - 1, num, dp)
    }
  }
}