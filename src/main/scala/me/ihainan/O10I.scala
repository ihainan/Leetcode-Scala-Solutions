package me.ihainan

object O10I {
  def fib(n: Int): Int = {
    var (a, b) = (0, 1)
    (1 to n).foreach { _ =>
      val sum = (a + b) % 1000000007
      a = b
      b = sum
    }
    a
  }
}