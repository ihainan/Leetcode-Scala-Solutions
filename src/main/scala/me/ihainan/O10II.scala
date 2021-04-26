package me.ihainan

object O10II {
  def numWays(n: Int): Int = {
    var (a, b) = (1, 2)
    (1 until n).foreach { _ =>
      val tmp = (a + b) % 1000000007
      a = b
      b = tmp
    }
    a
  }
}