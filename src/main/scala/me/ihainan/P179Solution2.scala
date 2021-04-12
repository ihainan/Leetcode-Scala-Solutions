package me.ihainan

object P179Solution2 {
  def largestNumber(nums: Array[Int]): String = {
    val str = nums.sortWith { case (v1, v2) =>
      var (x1, x2) = (10L, 10L)
      while (x1 <= v1) x1 *= 10
      while (x2 <= v2) x2 *= 10
      v1 * x2 + v2 > v2 * x1 + v1
    }.mkString

    if (str(0) == '0') "0"
    else str
  }
}