package me.ihainan

object P179 {
  def largestNumber(nums: Array[Int]): String = {
    val str = nums.sortWith { case (v1, v2) =>
      "" + v1 + v2 > "" + v2 + v1
    }.mkString

    if (str(0) == '0') "0"
    else str
  }
}