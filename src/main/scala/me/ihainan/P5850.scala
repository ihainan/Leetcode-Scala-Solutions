package me.ihainan

object P5850 {
  def gcd(a: Int, b: Int): Int = 
    if (a > b) gcd(b, a)
    else if (a == 0) b
    else gcd(a, b % a)

  def findGCD(nums: Array[Int]): Int = {
    gcd(nums.min, nums.max)
  }
}