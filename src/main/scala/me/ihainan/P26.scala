package me.ihainan

object P26 {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length <= 1) nums.length
    else {
      var i = 0
      nums.indices.foreach { j =>
        if (nums(i) != nums(j)) {
          i += 1
          nums(i) = nums(j)
        }
      }
      i + 1
    }
  }
}