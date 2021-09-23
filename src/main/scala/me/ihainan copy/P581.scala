package me.ihainan

object P581 {
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    val left = nums.indices.collectFirst { case i if nums(i) != sorted(i) => i }.getOrElse(return 0)
    val right = nums.indices.reverse.collectFirst { case i if nums(i) != sorted(i) => i }.getOrElse(return 0)
    right - left + 1
  }
}