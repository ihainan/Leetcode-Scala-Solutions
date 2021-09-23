package me.ihainan

object P1006 {
  def clumsy(N: Int): Int = {
    var ans = 0
    var n = N
    while (n > 0) {
      val (v1, v2) =
        if (n >= 4) (n * (n - 1) / (n - 2), (n - 3))
        else if (n == 3) (n * (n - 1) / (n - 2), 0)
        else if (n == 2) (n * (n - 1), 0)
        else (n, 0)
      if (n == N) ans += v1 + v2 else ans += -v1 + v2
      n -= 4
    }
    ans
  }
}