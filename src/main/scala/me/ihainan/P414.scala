package me.ihainan

object P414 {
  def thirdMax(nums: Array[Int]): Int = {
    var (m1, m2, m3) = (Long.MinValue, Long.MinValue, Long.MinValue)
    nums.foreach { num => if (num > m1) m1 = num }
    nums.foreach { num => if (num > m2 & num != m1) m2 = num }
    nums.foreach { num => if (num > m3 && num != m1 && num != m2) m3 = num }
    if (m3 == Long.MinValue) m1.toInt else m3.toInt
  }
}
