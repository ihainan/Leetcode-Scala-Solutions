package me.ihainan

object P80 {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length <= 2) return nums.length
    var i = 2
    (2 until nums.length).foreach { j =>
      if (nums(i - 2) != nums(j)) {
        nums(i) = nums(j)
        i += 1
      }
    }
    i
  }
}