package me.ihainan

object P219 {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    val map = collection.mutable.Map.empty[Int, Int]
    nums.indices.foreach { i =>
      if (map.isDefinedAt(nums(i)) && i - map(nums(i)) <= k) {
        return true
      }
      map(nums(i)) = i
    }
    false
  }
}