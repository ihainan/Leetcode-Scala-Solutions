package me.ihainan

object P35 {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    find(nums, 0, nums.length - 1, target)
  }

  @scala.annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (l > r) nums.length
    else if (nums(l) >= target) l
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) >= target) find(nums, l + 1, mid, target)
      else find(nums, mid + 1, r, target)
    }
  }
}