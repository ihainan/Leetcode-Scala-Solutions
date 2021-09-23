package me.ihainan

object O62 {
  def lastRemaining(n: Int, m: Int): Int = {
    def f(n: Int): Int = {
      if (n == 1) 0
      else ((m - 1) % n + 1 + f(n - 1)) % n // or (m + f(n - 1)) % n
    }

    f(n)
  }
}