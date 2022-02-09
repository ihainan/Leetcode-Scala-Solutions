package me.ihainan

object P2006 {
  def countKDifference(nums: Array[Int], k: Int): Int = {
    var ans = 0
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    nums.foreach { num =>
      ans += map(num - k) + map(k + num)
      map(num) = map(num) + 1
    }
    ans
  }
}