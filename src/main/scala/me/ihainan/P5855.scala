package me.ihainan

object P5855 {
  def compare(v1: String, v2: String): Int = {
    if (v1.length > v2.length) 1
    else if (v1.length < v2.length) -1
    else v1 compare v2
  }

  def swap(nums: Array[String], i: Int, j: Int): Unit = {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }

  def quickFind(nums: Array[String], l: Int, r: Int, target: Int): Unit = {
    if (l < r) {
      val tmp = nums(l)
      var (i, j) = (l, r)
      while (i < j) {
        while (i < j && compare(nums(j), tmp) > 0) j -= 1
        while (i < j && compare(nums(i), tmp) <= 0) i += 1
        swap(nums, i, j)
      }
      swap(nums, l, i)
      if (i > target) quickFind(nums, l, i - 1, target)
      else if (i < target) quickFind(nums, i + 1, r, target)
    }
  }

  def kthLargestNumber(nums: Array[String], k: Int): String = {
    quickFind(nums, 0, nums.length - 1, nums.length - k)
    nums(nums.length - k)
  }
}
