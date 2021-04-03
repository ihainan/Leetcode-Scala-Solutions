package me.ihainan

object P1143 {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val (m, n) = (text1.length, text2.length)
    val dp = Array.ofDim[Int](m + 1, n + 1)
    (1 to m).foreach { i =>
      (1 to n).foreach { j =>
        if (text1(i - 1) == text2(j - 1)) dp(i)(j) = (dp(i - 1)(j - 1) + 1).max(dp(i)(j - 1)).max(dp(i - 1)(j))
        else dp(i)(j) = dp(i)(j - 1).max(dp(i - 1)(j))
      }
    }
    dp(m)(n)
  }
}