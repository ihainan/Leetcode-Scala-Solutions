package me.ihainan

object P516 {
  def longestPalindromeSubseq(s: String): Int = {
    val n = s.length
    var ans = 1
    val dp = Array.fill(n, n)(0)
    (0 until s.length).foreach { i =>
      (s.length - 1 to i by -1).foreach { j =>
        val t1 = if (i == 0 || j == s.length - 1) 0 else dp(i - 1)(j + 1)
        val t2 = if (j == s.length - 1) 0 else dp(i)(j + 1)
        val t3 = if (i == 0) 0 else dp(i - 1)(j)
        if (i == j) dp(i)(j) = dp(i)(j).max(t1 + 1)
        else if (s(i) == s(j)) dp(i)(j) = dp(i)(j).max(t1 + 2)
        else dp(i)(j) = dp(i)(j).max(t2).max(t3)
        ans = ans.max(dp(i)(j))
      }
    }
    ans
  }
}