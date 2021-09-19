package me.ihainan

object P650Solution3 {
  def minSteps(n: Int): Int = {
    var ans = 0
    var nn = n
    var i = 2
    while (i * i <= nn) {
      while (nn % i == 0) {
        ans += i
        nn /= i
      }
      i += 1
    }
    if (nn > 1) ans += nn
    ans
  }
}