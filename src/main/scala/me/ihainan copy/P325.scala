package me.ihainan

object P325 {
  def maxSubArrayLen(nums: Array[Int], k: Int): Int = {
    val map = collection.mutable.Map.empty[Int, Int]
    var sum = 0
    var ans = 0
    nums.indices.foreach { i =>
      sum += nums(i)
      if (sum == k) ans = ans.max(i + 1)
      if (map.isDefinedAt(sum - k)) ans = ans.max(i - map(sum - k))
      if (!map.isDefinedAt(sum)) map(sum) = i
    }
    ans
  }
}