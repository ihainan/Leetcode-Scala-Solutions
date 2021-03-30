package me.ihainan

object O10II {
  def numWays(n: Int): Int = {
    if (n == 0) 1
    else {
      var (a, b) = (1, 2)
      (2 to n).foreach { _ =>
        val sum = (a + b) % 1000000007
        a = b
        b = sum
      }
      a
    }
  }
}