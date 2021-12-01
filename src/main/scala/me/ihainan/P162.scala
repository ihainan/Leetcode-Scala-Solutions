package me.ihainan

object P162 {
  def findPeakElement(nums: Array[Int]): Int = {
    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) -1
      else if (l == r) l
      else {
        val m = (l + r) >>> 1
        if (nums(m) < nums(m + 1)) find(m + 1, r)
        else find(l, m)
      }
    }

    find(0, nums.length - 1)
  }
}
