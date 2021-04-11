package me.ihainan

object O61 {
  def isStraight(nums: Array[Int]): Boolean = {
    var (min, max) = (13, 0)
    val set = collection.mutable.Set.empty[Int]
    nums.foreach { num =>
      if (num != 0) {
        if (set(num)) return false else set += num
        min = min.min(num)
        max = max.max(num)
      }
    }
    max - min < 5
  }
}