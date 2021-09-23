package me.ihainan

object O57Solution2 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val set = collection.mutable.Set.empty[Int]
    nums.foreach { num =>
      if (set(target - num)) return Array(num, target - num)
      else set += num
    }
    Array.empty
  }
}
