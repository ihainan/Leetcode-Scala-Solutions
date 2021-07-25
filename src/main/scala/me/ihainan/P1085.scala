package me.ihainan

object P1085 {
  def sumOfDigits(nums: Array[Int]): Int = {
    val min = nums.min
    val sum = min.toString.map(c => c - '0').sum
    if (sum % 2 == 0) 1 else 0
  }
}