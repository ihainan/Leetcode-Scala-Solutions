package me.ihainan

object O53II {
  def missingNumber(nums: Array[Int]): Int = {
    (0 to nums.length).reduce(_ ^ _) ^ nums.reduce(_ ^ _)
  }
}