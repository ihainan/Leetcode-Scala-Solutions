package me.ihainan

object O56I {
  def singleNumbers(nums: Array[Int]): Array[Int] = {
    val xorValue = nums.reduce(_ ^ _)
    val lastOne = xorValue & -xorValue
    val ans = new Array[Int](2)
    nums.foreach { num =>
      if ((num & lastOne) > 0) ans(0) ^= num
      else ans(1) ^= num
    }
    ans
  }
}
