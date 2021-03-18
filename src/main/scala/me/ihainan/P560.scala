package me.ihainan

object P560 {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    var ans = 0
    var sum = 0
    nums.foreach { num =>
      sum += num
      if (sum == k) ans += 1
      ans += map(sum - k)
      map(sum) = map(sum) + 1
    }
    ans
  }
}