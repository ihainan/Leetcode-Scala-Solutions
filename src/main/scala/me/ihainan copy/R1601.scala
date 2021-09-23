package me.ihainan

object R1601 {
  def swapNumbers(nums: Array[Int]): Array[Int] = {
    nums(1) = nums(0) ^ nums(1)
    nums(0) = nums(0) ^ nums(1)
    nums(1) = nums(0) ^ nums(1)
    nums
  }
}