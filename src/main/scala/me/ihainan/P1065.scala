package me.ihainan

object P1065 {
  def indexPairs(text: String, words: Array[String]): Array[Array[Int]] = {
    val sorted = words.sortBy(_.length)
    text.indices.flatMap { i =>
      sorted.flatMap { word =>
        val len = word.length
        if (i + len <= text.length && text.substring(i, i + len) == word) {
          Some(Array(i, i + len - 1))
        } else None
      }
    }.toArray
  }
}