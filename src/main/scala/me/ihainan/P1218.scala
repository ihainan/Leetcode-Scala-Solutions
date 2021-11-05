package me.ihainan

object P1218 {
  def longestSubsequence(arr: Array[Int], difference: Int): Int = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    var ans = 0
    arr.indices.reverse.foreach { i =>
      map(arr(i)) = map(arr(i) + difference) + 1
      ans = ans.max(map(arr(i)))
    }
    ans
  }
}
