package me.ihainan

object P44 {
  def isMatch(s: String, p: String): Boolean = {
    val (m, n) = (s.length, p.length)
    val dp = Array.fill(m + 1, n + 1)(false)
    (0 to m).foreach { i =>
      (0 to n).foreach { j =>
        if (i == 0 && j == 0) dp(i)(j) = true
        else if (i == 0 && j != 0) dp(i)(j) = dp(i)(j - 1) && p(j - 1) == '*'
        else if (i != 0 && j == 0) dp(i)(j) = false
        else if (p(j - 1) == '?') dp(i)(j) = dp(i - 1)(j - 1)
        else if (p(j - 1) == '*')
          dp(i)(j) = dp(i)(j - 1) || dp(i - 1)(j - 1) || dp(i - 1)(j)
        else dp(i)(j) = dp(i - 1)(j - 1) && s(i - 1) == p(j - 1)
      // println(i, j, dp(i)(j))
      }
    }
    dp.last.last
  }
}
