package me.ihainan

object P645Solution3 {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    val duplicate = nums.sum - nums.toSet.sum
    val missing = (1 to nums.length).sum - nums.sum + duplicate
    Array(duplicate, missing)
  }
}