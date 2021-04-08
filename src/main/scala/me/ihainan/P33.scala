package me.ihainan

object P33 {
  @annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (l > r) -1
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) == target) mid
      else if (nums(0) <= nums(mid)) {
        if (nums(0) <= target && target < nums(mid)) find(nums, l, mid - 1, target)
        else find(nums, mid + 1, r, target)
      } else {
        if (nums(nums.length - 1) >= target && target > nums(mid)) find(nums, mid + 1, r, target)
        else find(nums, l, mid - 1, target)
      }
    }
  }

  def search(nums: Array[Int], target: Int): Int = {
    find(nums, 0, nums.length - 1, target)
  }
}