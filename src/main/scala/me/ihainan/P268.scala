package me.ihainan

object P268 {
  def missingNumber(nums: Array[Int]): Int = {
    (((nums.length + 1) * nums.length) >>> 1) - nums.sum
  }
}