package me.ihainan

object P153Solution2 {
  def findMin(nums: Array[Int]): Int = {
    nums(find(0, nums.length - 1, nums))
  }

  @scala.annotation.tailrec
  def find(l: Int, r: Int, nums: Array[Int]): Int = {
    if (l == r) l
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) > nums(r)) find(mid + 1, r, nums)
      else find(l, mid, nums)
    }
  }
}