package me.ihainan

object O03 {
  def findRepeatNumber(nums: Array[Int]): Int = {
    nums.indices.foreach { i =>
      val num = nums(i)
      val index = if (num < 0) (num + 1).abs else num
      if (nums(index) < 0) return index
      else nums(index) = -(nums(index) + 1)
    }
    -1
  }
}