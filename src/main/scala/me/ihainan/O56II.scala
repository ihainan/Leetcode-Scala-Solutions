package me.ihainan

object O56II {
  def singleNumber(nums: Array[Int]): Int = {
    (0 until 32).map { i =>
      val mask = 1 << i
      var sum = nums.map { num => if ((num & mask) == 0) 0 else 1 }.sum
      (sum % 3) << i
    }.sum
  }
}