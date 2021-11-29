package me.ihainan

object P231 {

  def isPowerOfTwo(n: Int): Boolean = {
    n > 0 && (1 << 30) % n == 0
  }
}
