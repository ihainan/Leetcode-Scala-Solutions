package me.ihainan

object P72 {
  def minDistance(word1: String, word2: String): Int = {
    val (m, n) = (word1.length, word2.length)
    var dp = (0 to n).toArray

    (1 to m).foreach { i =>
      val tp = new Array[Int](n + 1)
      tp(0) = i
      (1 to n).foreach { j =>
        if (word1(i - 1) == word2(j - 1)) tp(j) = dp(j - 1)
        else tp(j) = 1 + (dp(j - 1).min(dp(j)).min(tp(j - 1)))
      }
      dp = tp
    }

    dp.last
  }
}
