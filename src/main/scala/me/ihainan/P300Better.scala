package me.ihainan

object P300Better {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val dp = new Array[Int](nums.length + 1)
    var len = 1
    dp(len) = nums(0)

    @annotation.tailrec
    def find(l: Int, r: Int, target: Int): Int = {
      if (l > r) 0
      else if (dp(r) < target) r
      else {
        val m = (l + r) >>> 1
        if (dp(m) < target) find(m, r - 1, target)
        else find(l, m - 1, target)
      }
    }

    (1 until nums.length).foreach { i =>
      if (nums(i) > dp(len)) {
        len += 1
        dp(len) = nums(i)
      } else {
        val j = find(1, len, nums(i))
        dp(j + 1) = nums(i)
      }
    }

    len
  }
}