package me.ihainan

object P153 {
  def findMin(nums: Array[Int]): Int = {
    @annotation.tailrec
    def find(l: Int, r: Int): Int = {
      if (l > r) -1
      else if (nums(l) <= nums(r)) nums(l)
      else {
        val m = (l + r + 1) >>> 1
        if (nums(m) > nums(l)) find(m + 1, r)
        else find(l + 1, m)
      }
    }

    find(0, nums.length - 1)
  }
}
