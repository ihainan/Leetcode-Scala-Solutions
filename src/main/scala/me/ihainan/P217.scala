package me.ihainan

object P217 {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    nums.toSet.size != nums.length
  }
}