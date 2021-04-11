package me.ihainan

object O45 {
  def minNumber(nums: Array[Int]): String = {
    nums.sortWith { case (v1, v2) => "" + v1 + v2 < "" + v2 + v1 }.mkString
  }
}