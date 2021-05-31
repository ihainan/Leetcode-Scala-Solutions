package me.ihainan

object P342_4 {
  def isPowerOfFour(n: Int): Boolean = {
    if (n <= 0) false
    else if ((n & -n) != n) false
    else if (n.toBinaryString.count(_ == '0') % 2 != 0) false
    else true
  }
}