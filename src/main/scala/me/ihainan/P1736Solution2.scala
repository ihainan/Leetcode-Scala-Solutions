package me.ihainan

object P1736Solution2 {
  def maximumTime(time: String): String = {
    val ans = time.toCharArray

    if (ans(0) == '?') {
      if (ans(1) != '?' && ans(1) >= '4') ans(0) = '1' else ans(0) = '2'
    }

    if (ans(1) == '?') {
      if (ans(0) == '2') ans(1) = '3' else ans(1) = '9'
    }

    if (ans(3) == '?') ans(3) = '5'
    if (ans(4) == '?') ans(4) = '9'

    new String(ans)
  }
}