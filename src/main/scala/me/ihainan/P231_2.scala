package me.ihainan

object P231_2 {
  def isPowerOfTwo(n: Int): Boolean = {
    n > 0 && (n & -n) == n
  }
}