package me.ihainan

object R1710Better {
  def majorityElement(nums: Array[Int]): Int = {
    var (vote, current) = (1, -1)
    nums.foreach { num =>
      if (num == current) vote += 1
      else vote -= 1
      if (vote == 0) {
        current = num
        vote = 1
      }
    }
    vote = nums.count(num => num == current)
    if (vote * 2 > nums.length) current else -1
  }
}