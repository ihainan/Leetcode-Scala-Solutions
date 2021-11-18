package me.ihainan

object P318 {
  def maxProduct(words: Array[String]): Int = {
    val sets = words.map(_.toSet)
    var ans = 0
    sets.indices.foreach { i =>
      (i + 1 until sets.length).foreach { j =>
        if (sets(i).intersect(sets(j)).isEmpty) {
          ans = ans.max(words(i).length * words(j).length)
        }
      }
    }
    ans
  }
}