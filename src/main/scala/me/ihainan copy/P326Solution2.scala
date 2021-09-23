package me.ihainan

object P326Solution2 {
  def isPowerOfThree(n: Int): Boolean = {
    n > 0 && math.pow(3, 19).toInt % n == 0
  }
}
