package me.ihainan

object R0803 {
  def findMagicIndex(nums: Array[Int]): Int = {
    find(nums, 0, nums.length - 1)
  }

  def find(nums: Array[Int], l: Int, r: Int): Int = {
    if (l > r) -1
    else if (nums(l) == l) l
    else {
      val mid = (l + r) / 2
      if (nums(mid) == mid) find(nums, l + 1, mid)
      else {
        val v = find(nums, l + 1, mid - 1)
        if (v != -1) v
        else find(nums, mid + 1, r)
      }
    }
  }
}