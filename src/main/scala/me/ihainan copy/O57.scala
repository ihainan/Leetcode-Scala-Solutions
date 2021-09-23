package me.ihainan

object O57 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var (i, j) = (0, nums.length - 1)
    while (i < j) {
      if (target - nums(i) == nums(j)) return Array(nums(i), nums(j))
      else if (target - nums(i) > nums(j)) i += 1
      else j -= 1
    }
    Array.empty[Int]
  }
}