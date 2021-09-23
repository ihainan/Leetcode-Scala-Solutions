package me.ihainan

object O39 {
  def majorityElement(nums: Array[Int]): Int = {
    var (current, count) = (nums.head, 0)
    nums.foreach { num =>
      if (num == current) count += 1
      else count -= 1
      if (count == 0) {
        current = num
        count = 1
      }
    }
    current
  }
}