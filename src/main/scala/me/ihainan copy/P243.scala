package me.ihainan

object P243 {
  def shortestDistance(wordsDict: Array[String], word1: String, word2: String): Int = {
    var ans = Int.MaxValue
    var (i, j) = (-1, -1)
    wordsDict.indices.foreach { k =>
      if (wordsDict(k) == word1) {
        i = k
        if (j != -1) ans = ans.min(i - j)
      } else if (wordsDict(k) == word2) {
        j = k
        if (i != -1) ans = ans.min(j - i)
      }
    }
    ans
  }
}