package me.ihainan

object P583Solution2 {
  def minDistance(word1: String, word2: String): Int = {
    val (m, n) = (word1.length, word2.length)
    val dp = Array.fill(m + 1, n + 1)(0)
    (0 to n).foreach(j => dp(0)(j) = j)
    (0 to m).foreach(i => dp(i)(0) = i)
    (1 to m).foreach { i =>
      (1 to n).foreach { j =>
        if (word1(i - 1) == word2(j - 1)) dp(i)(j) = dp(i - 1)(j - 1)
        else dp(i)(j) = dp(i - 1)(j).min(dp(i)(j - 1)) + 1
      }
    }
    dp.last.last
  }
}