package me.ihainan

object P645Solution2 {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    val array = nums ++ (1 to nums.length)
    val xy = array.reduce(_ ^ _)
    val lowBit = xy & -xy
    var (a, b) = (0, 0)
    array.foreach { num => 
      if ((num & lowBit) == 0) a ^= num
      else b ^= num
    } 
    nums.foreach { num => if (num == a) return Array(a, b) else if (num == b) return Array(b, a) }
    Array.empty
  }
}