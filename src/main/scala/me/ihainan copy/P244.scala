package me.ihainan

object P244 {

  class WordDistance(_wordsDict: Array[String]) {
    val map = collection.mutable.Map.empty[String, List[Int]].withDefaultValue(Nil)
    _wordsDict.indices.foreach { i => map(_wordsDict(i)) = map(_wordsDict(i)) :+ i }

    def shortest(word1: String, word2: String): Int = {
      val (l1, l2) = (map(word1), map(word2))
      var ans = Int.MaxValue
      var (i, j) = (0, 0)
      while (i != l1.length && j != l2.length) {
        ans = ans.min((l1(i) - l2(j)).abs)
        if (l1(i) < l2(j)) i += 1
        else j += 1
      }
      ans
    }

  }

  /**
    * Your WordDistance object will be instantiated and called as such:
    * var obj = new WordDistance(wordsDict)
    * var param_1 = obj.shortest(word1,word2)
    */
}