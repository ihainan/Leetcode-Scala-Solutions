package me.ihainan

object P516 {
  def longestPalindromeSubseq(s: String): Int = {
    val dp = Array.fill(s.length, s.length)(0)
    (1 to s.length).foreach { l =>
      (0 to s.length - l).foreach { i =>
        val j = i + l - 1
        if (i == j) dp(i)(j) = 1
        else if (s(i) == s(j)) dp(i)(j) = dp(i + 1)(j - 1) + 2
        else dp(i)(j) = dp(i + 1)(j).max(dp(i)(j - 1))
      }
    }
    dp(0)(s.length - 1)
  }
}
