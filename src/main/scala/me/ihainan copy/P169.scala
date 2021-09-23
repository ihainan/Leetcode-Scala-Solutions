package me.ihainan

object P169 {
  def majorityElement(nums: Array[Int]): Int = {
    var (current, votes) = (nums(0), 1)
    nums.foreach { num =>
      if (num != current) votes -= 1
      else votes += 1
      if (votes == 0) {
        votes = 1
        current = num
      }
    }
    current
  }
}