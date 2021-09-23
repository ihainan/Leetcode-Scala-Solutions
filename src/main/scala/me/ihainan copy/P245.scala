package me.ihainan

object P245 {
  def shortestWordDistance(wordsDict: Array[String], word1: String, word2: String): Int = {
    var ans = Int.MaxValue
    var (i, j) = (-1, -1)
    wordsDict.indices.foreach { k =>
      if (wordsDict(k) == word1 && j != -1) ans = ans.min(k - j)
      if (wordsDict(k) == word2 && i != -1) ans = ans.min(k - i)
      if (wordsDict(k) == word1) i = k
      if (wordsDict(k) == word2) j = k
    }
    ans
  }
}