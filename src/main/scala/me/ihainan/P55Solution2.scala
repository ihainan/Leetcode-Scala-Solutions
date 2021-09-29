package me.ihainan

object P55Solution2 {
  def canJump(nums: Array[Int]): Boolean = {
    var (i, max) = (0, 0)
    nums.indices.foreach { i =>
      if (i > max) return false
      else max = max.max(i + nums(i))
      if (max >= nums.length - 1) return true
    }
    true
  }
}
