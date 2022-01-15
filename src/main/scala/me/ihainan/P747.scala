package me.ihainan

object P747 {
  def dominantIndex(nums: Array[Int]): Int = {
    var max = Int.MinValue
    var sMax = Int.MinValue
    var maxI = 0
    nums.indices.foreach { i =>
      if (nums(i) > max) {
        sMax = max
        max = nums(i)
        maxI = i
      } else if (nums(i) > sMax) {
        sMax = nums(i)
      }
    }

    if (max >= sMax * 2) maxI else -1
  }
}
