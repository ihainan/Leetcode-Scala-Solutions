package me.ihainan

object O11 {
  def minArray(nums: Array[Int]): Int = {
    nums(find(0, nums.length - 1, nums))
  }

  def find(l: Int, r: Int, nums: Array[Int]): Int = {
    if (l == r) l
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) > nums(r)) find(mid + 1, r, nums)
      else if (nums(mid) < nums(r)) find(l, mid, nums)
      else find(l, r - 1, nums)
    }
  }
}