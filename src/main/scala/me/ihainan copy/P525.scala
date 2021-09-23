package me.ihainan

object P525 {
  def findMaxLength(nums: Array[Int]): Int = {
    val map = collection.mutable.Map.empty[Int, Int]
    map(0) = -1
    var tmp = 0
    var ans = 0
    nums.indices.foreach { i =>
      val num = nums(i)
      if (num == 0) tmp -= 1
      else tmp += 1
      if (map.isDefinedAt(tmp)) ans = ans.max(i - map(tmp))
      else map(tmp) = i
    }
    ans
  }
}