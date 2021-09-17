package me.ihainan

object P162 {
  def findPeakElement(nums: Array[Int]): Int = {
    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) -1
      else {
        val m = (l + r) >>> 1
        val left = if (m == 0) Long.MinValue else nums(m - 1)
        val right = if (m == nums.length - 1) Long.MinValue else nums(m + 1)
        if (left < nums(m) && nums(m) > right) m
        else if (nums(m) < right) find(m + 1, r)
        else find(l, m - 1)
      }
    }

    find(0, nums.length - 1)
  }
}
