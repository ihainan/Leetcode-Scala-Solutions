package me.ihainan

object R1711 {
  def findClosest(words: Array[String], word1: String, word2: String): Int = {
    import collection.mutable.Map

    val map = Map.empty[String, List[Int]].withDefaultValue(Nil)
    words.indices.foreach { i => map(words(i)) = map(words(i)) :+ i }

    var ans = Int.MaxValue
    map(word1).foreach { i =>
      map(word2).foreach { j =>
        if ((i - j).abs < ans) ans = (i - j).abs
      }
    }

    ans
  }
}