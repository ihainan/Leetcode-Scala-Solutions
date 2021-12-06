package me.ihainan

object P144 {
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    magazine.foreach(c => map(c) += 1)
    ransomNote.foreach { c =>
      if (map(c) == 0) return false
      else map(c) -= 1
    }
    true
  }
}