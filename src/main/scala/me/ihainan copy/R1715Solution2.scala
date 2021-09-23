package me.ihainan

object R1715Solution2 {
  def findClosest(words: Array[String], word1: String, word2: String): Int = {
    import collection.mutable.Map

    val map = Map.empty[String, List[Int]].withDefaultValue(Nil)
    words.indices.foreach { i => map(words(i)) = map(words(i)) :+ i }

    find(map(word1), map(word2))
  }

  def find(l1: List[Int], l2: List[Int]): Int = {
    var (i, j) = (0, 0)
    var ans = (l1(i) - l2(j)).abs
    while (i < l1.length - 1 || j < l2.length - 1) {
      if (i == l1.length - 1 || (j < l2.length - 1 && l1(i) > l2(j))) j += 1
      else i += 1
      ans = ans.min((l1(i) - l2(j)).abs)
    }
    ans
  }
}