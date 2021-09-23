package me.ihainan

object P342_4 {
  def isPowerOfFour(n: Int): Boolean = {
    n > 0 && (n & -n) == n && (n & 0xAAAAAAAA) == 0
  }
}