package me.ihainan

object P523 {
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    val map = collection.mutable.Map.empty[Int, Int]
    var tmp = 0
    nums.indices.foreach { i =>
      tmp += nums(i);
      val modValue = tmp % k
      if (i >= 1 && modValue == 0) return true
      if (map.isDefinedAt(modValue)) {
        if (i - map(modValue) >= 2) return true
      } else map(modValue) = i
    }
    false
  }
}