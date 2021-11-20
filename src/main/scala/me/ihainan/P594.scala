package me.ihainan

object P594 {
  def findLHS(nums: Array[Int]): Int = {
    val map = collection.mutable.Map.empty[(Int, Int), Int].withDefaultValue(0)
    val set = collection.mutable.Set.empty[Int]
    var ans = 0
    nums.foreach { num =>
      map((num - 1, num)) += 1
      map((num, num + 1)) += 1
      if (set(num - 1)) ans = ans.max(map((num - 1, num)))
      if (set(num + 1)) ans = ans.max(map((num, num + 1)))
      set += num
    }
    ans
  }
}
