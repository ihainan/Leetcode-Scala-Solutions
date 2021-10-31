package me.ihainan

object P500 {
  def findWords(words: Array[String]): Array[String] = {
    val rows = Array(
      "qwertyuiop".toSet,
      "asdfghjkl".toSet,
      "zxcvbnm".toSet
    )

    words.filter { word =>
      rows.exists { set =>
        !word.exists(c => !set(Character.toLowerCase(c)))
      }
    }
  }
}
