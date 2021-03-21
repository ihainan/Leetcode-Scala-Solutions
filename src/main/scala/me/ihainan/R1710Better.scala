package me.ihainan

object R1710Better {
  def majorityElement(nums: Array[Int]): Int = {
    var tmp = nums.head
    var count = 0
    nums.foreach { num =>
      if (count == 0) {
        count = 1
        tmp = num
      } else {
        if (num == tmp) count += 1
        else count -= 1
      }
    }

    if (count > 0) {
      count = 0
      nums.foreach { num => if (num == tmp) count += 1 }
      if (count > nums.length / 2) tmp
      else -1
    } else -1
  }
}