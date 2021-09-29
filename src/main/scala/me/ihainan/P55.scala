package me.ihainan

object P55 {
  def canJump(nums: Array[Int]): Boolean = {
    val visited = collection.mutable.Set(0)
    nums.indices.foreach { i =>
      if (visited(i)) {
        (i + 1 to i + nums(i)).foreach { j => visited += j }
      }
      if (visited(nums.length - 1)) return true
    }
    false
  }
}