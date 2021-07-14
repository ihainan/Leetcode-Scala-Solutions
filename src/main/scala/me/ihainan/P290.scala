package me.ihainan

object P290 {
  def wordPattern(pattern: String, s: String): Boolean = {
    val words = s.split(" ")
    val char2String = collection.mutable.Map.empty[Char, String]
    val string2Char = collection.mutable.Map.empty[String, Char]
    if (words.length != pattern.length) false
    else {
      pattern.zip(words).foreach { case (c, word) =>
        if (!char2String.isDefinedAt(c)) char2String(c) = word
        else if (char2String(c) != word) return false
        if (!string2Char.isDefinedAt(word)) string2Char(word) = c
        else if (string2Char(word) != c) return false
      }
      true
    }
  }
}
