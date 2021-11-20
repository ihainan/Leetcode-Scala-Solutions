package me.ihainan

object P397Solution2 {
  def integerReplacement(n: Int): Int = {
    var nn = n
    var ans = 0
    while (nn != 1) {
      if (nn % 2 == 0) {
        nn >>>= 1
        ans += 1
      } else if (nn == 3) {
        nn = 1
        ans += 2
      } else {
        if (nn % 4 == 1) nn = (nn - 1) >>> 1 else nn = (nn + 1) >>> 1
        ans += 2
      }
    }

    ans
  }
}