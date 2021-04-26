package me.ihainan

object O11 {
  def minArray(nums: Array[Int]): Int = {
    find(0, nums.length - 1, nums)
  }

  @annotation.tailrec
  def find(l: Int, r: Int, nums: Array[Int]): Int = {
    if (l == r) nums(l)
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) < nums(r)) find(l, mid, nums)
      else if (nums(mid) > nums(r)) find(mid + 1, r, nums)
      else find(l, r - 1, nums)
    }
  }
}