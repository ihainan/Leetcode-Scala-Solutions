package me.ihainan

object O53I {
  def search(nums: Array[Int], target: Int): Int = {
    val right = find(nums, 0, nums.length - 1, target)
    if (right == -1 || nums(right) != target) 0
    else {
      val left = find(nums, 0, nums.length - 1, target - 1)
      if (left == -1) right + 1
      else right - left
    }
  }

  @annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (l > r) -1
    else if (nums(r) <= target) r
    else {
      val mid = (l + r) >>> 1
      if (nums(mid) > target) find(nums, l, mid - 1, target)
      else find(nums, mid, r - 1, target)
    }
  }
}