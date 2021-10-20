package me.ihainan

object P453Solution2 {
  def minMoves(nums: Array[Int]): Int = {
    val min = nums.min
    nums.map(num => num - min).sum
  }
}