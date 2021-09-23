package me.ihainan

object P263 {
  def isUgly(n: Int): Boolean = {
    if (n <= 0) return false
    var nn = n
    Array(2, 3, 5).foreach { i =>
      while (nn % i == 0) nn /= i
    }
    nn == 1
  }
}