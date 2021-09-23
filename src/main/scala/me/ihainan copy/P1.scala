package me.ihainan

object P1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = collection.mutable.Map.empty[Int, Int]
    nums.indices.foreach { i =>
      if (map.isDefinedAt(target - nums(i))) return Array(map(target - nums(i)), i)
      else map(nums(i)) = i
    }
    Array.empty[Int]
  }
}