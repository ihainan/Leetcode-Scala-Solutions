package me.ihainan

object R1719 {
  def missingTwo(nums: Array[Int]): Array[Int] = {
    val xorValue = (1 to nums.length + 2).reduce(_ ^ _) ^ nums.reduce(_ ^ _)
    val lastOne = xorValue & -xorValue
    val ans = new Array[Int](2)
    (1 to nums.length + 2).foreach { num =>
      if ((num & lastOne) > 0) ans(0) ^= num
      else ans(1) ^= num
    }

    nums.foreach { num =>
      if ((num & lastOne) > 0) ans(0) ^= num
      else ans(1) ^= num
    }

    ans
  }
}