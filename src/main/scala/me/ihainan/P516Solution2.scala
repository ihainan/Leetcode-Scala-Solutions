package me.ihainan

object P516Solution2 {
  def lcs(s1: String, s2: String): Int = {
    val dp = Array.fill(s1.length + 1, s2.length + 1)(0)
    (1 to s1.length).foreach { i =>
      (1 to s2.length).foreach { j =>
        if (s1(i - 1) == s2(j - 1)) dp(i)(j) = dp(i - 1)(j - 1) + 1
        else dp(i)(j) = dp(i)(j - 1).max(dp(i - 1)(j))
      }
    }
    dp.last.last
  }

  def longestPalindromeSubseq(s: String): Int = {
    var ans = 1
    (0 until s.length).foreach { i =>
      val s1 = s.substring(0, i + 1)
      val s2 = s.substring(i + 1, s.length).reverse
      val s3 =
        if (i + 2 < s.length) s.substring(i + 2, s.length).reverse else ""
      ans = ans.max(lcs(s1, s2) * 2).max(lcs(s1, s3) * 2 + 1)
    }
    ans
  }
}
