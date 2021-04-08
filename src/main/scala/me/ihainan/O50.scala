package me.ihainan

object O50 {
  def firstUniqChar(s: String): Char = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach { c => map(c) = map(c) + 1 }
    s.foreach { c => if (map(c) == 1) return c }
    ' '
  }
}