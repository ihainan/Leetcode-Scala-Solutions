package me.ihainan

object P326 {
  def isPowerOfThree(n: Int): Boolean = {
    var nn = n
    while (nn > 1 && nn % 3 == 0) nn /= 3
    nn == 1
  }
}
