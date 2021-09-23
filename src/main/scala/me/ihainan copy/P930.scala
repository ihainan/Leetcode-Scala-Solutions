package me.ihainan

object P930 {
  def numSubarraysWithSum(nums: Array[Int], goal: Int): Int = {
    var sum = 0
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    var ans = 0
    nums.foreach { num =>
      sum += num
      if (sum == goal) ans += 1
      ans += map(sum - goal)
      map(sum) = map(sum) + 1
    }
    ans
  }
}