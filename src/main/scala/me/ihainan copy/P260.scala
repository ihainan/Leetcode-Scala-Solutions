package me.ihainan

object P260 {
  def singleNumber(nums: Array[Int]): Array[Int] = {
    val xorValue = nums.reduce(_ ^ _)
    var (num1, num2) = (0, 0)
    val lastOne = xorValue & -xorValue
    nums.foreach { num =>
      if ((num & lastOne) > 0) num1 ^= num
      else num2 ^= num
    }
    Array(num1, num2)
  }
}