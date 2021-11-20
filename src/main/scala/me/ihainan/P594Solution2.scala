package me.ihainan

object P594Solution2 {
  def findLHS(nums: Array[Int]): Int = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    nums.foreach(num => map(num) += 1)
    var ans = 0
    map.foreach { case (k, v) =>
      if (map(k + 1) != 0) ans = ans.max(v + map(k + 1))
    }
    ans
  }
}
