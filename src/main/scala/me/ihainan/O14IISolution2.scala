package me.ihainan

object O14IISolution2 {
  def quickPow(x: Long, y: Long, mod: Long): Long = {
    if (y == 0) 1
    else if (y == 1) x % mod
    else {
      val half = quickPow(x, y / 2, mod)
      val doubleAns = (half * half) % mod
      if (y % 2 == 0) doubleAns
      else (doubleAns * (x % mod)) % mod
    }
  }

  def cuttingRope(n: Int): Int = {
    if (n <= 3) n - 1
    else {
      val mod = 1000000007
      val x = n / 3
      val m = n % 3
      val ans =
        if (m == 0) quickPow(3, x, mod)
        else if (m == 1) (quickPow(3, x - 1, mod) * 4) % mod
        else (quickPow(3, x - 1, mod) * 6) % mod
      ans.toInt
    }
  }
}