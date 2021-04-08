package me.ihainan

object P81 {
  def find(nums: Array[Int], l: Int, r: Int, target: Int): Boolean = {
    if (l > r) false
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) == target) true
      else if (nums(mid) > nums(0)) {
        if (nums(0) <= target && target < nums(mid)) find(nums, l, mid - 1, target)
        else find(nums, mid + 1, r, target)
      } else if (nums(mid) < nums(0)) {
        if (target > nums(mid) && target <= nums(nums.length - 1)) find(nums, mid + 1, r, target)
        else find(nums, l, mid - 1, target)
      } else {
        find(nums, l, mid - 1, target) || find(nums, mid + 1, r, target)
      }
    }
  }

  def search(nums: Array[Int], target: Int): Boolean = {
    find(nums, 0, nums.length - 1, target)
  }
}