package me.ihainan

object P704 {
  @annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int, target: Int): Int = {
    if (l > r) -1
    else {
      val m = (l + r) >>> 1
      if (nums(m) == target) m
      else if (nums(m) > target) find(nums, l, m - 1, target)
      else find(nums, m + 1, r, target)
    }
  }
  
  def search(nums: Array[Int], target: Int): Int = {
    find(nums, 0, nums.length - 1, target)
  }
}
