package me.ihainan

object O62 {
  def lastRemaining(n: Int, m: Int): Int = {
    solve(n, m)
  }

  def solve(n: Int, m: Int): Int = {
    if (n == 1) 0
    else (m + solve(n - 1, m)) % n
  }
}