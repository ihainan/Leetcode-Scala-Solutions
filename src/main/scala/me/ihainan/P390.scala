package me.ihainan

object P390 {
  def lastRemaining(n: Int): Int = {
    var (cnt, step, k, first) = (n, 1, 1, 1)
    while (cnt != 1) {
      if (cnt % 2 == 1 || k % 2 != 0) first = first + step
      cnt /= 2
      step *= 2
      k += 1
    }
    first
  }
}