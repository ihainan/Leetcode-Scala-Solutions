package me.ihainan

object OII004 {
  def singleNumber(nums: Array[Int]): Int = {
    var ans = 0
    (0 until 32).foreach { i =>
      val mask = 1 << i
      var sum = 0
      nums.foreach { num =>
        val v = if ((num & mask) != 0) 1 else 0
        sum += v
      }
      ans += (sum % 3) << i
    }
    ans
  }
}