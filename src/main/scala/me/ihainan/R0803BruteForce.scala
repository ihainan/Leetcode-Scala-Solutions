package me.ihainan

object R0803BruteForce {
  def findMagicIndex(nums: Array[Int]): Int = {
    nums.indices.collectFirst { case i if nums(i) == i => i }.getOrElse(-1)
  }
}