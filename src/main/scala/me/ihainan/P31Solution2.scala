package me.ihainan

object P31Solution2 {
  def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }

  def reverse(nums: Array[Int], f: Int, t: Int): Unit = {
    var (i, j) = (f, t)
    while (i < j) {
      swap(nums, i, j)
      i += 1
      j -= 1
    }
  }

  def nextPermutation(nums: Array[Int]): Unit = {
    var i = nums.length - 2
    while (i >= 0 && nums(i) >= nums(i + 1)) i -= 1
    if (i >= 0) {
      var j = nums.length - 1
      while (j > i && nums(j) <= nums(i)) j -= 1
      swap(nums, i, j)
    }
    reverse(nums, i + 1, nums.length - 1)
  }
}