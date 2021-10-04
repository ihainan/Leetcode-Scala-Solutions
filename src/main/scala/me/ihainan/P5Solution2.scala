package me.ihainan

object P5Solution2 {
  def longestPalindrome(s: String): String = {
    var (ansS, ansE) = (0, 0)

    def expand(l: Int, r: Int): (Int, Int) = {
      var (i, j) = (l, r)
      while (i >= 0 && j < s.length && s(i) == s(j)) {
        i -= 1
        j += 1
      }
      (i + 1, j - 1)
    }

    s.indices.foreach { i =>
      val (s1, e1) = expand(i, i)
      val (s2, e2) = expand(i, i + 1)
      if (e1 - s1 > ansE - ansS) {
        ansS = s1
        ansE = e1
      }
      if (e2 - s2 > ansE - ansS) {
        ansS = s2
        ansE = e2
      }
    }

    s.substring(ansS, ansE + 1)
  }
}
