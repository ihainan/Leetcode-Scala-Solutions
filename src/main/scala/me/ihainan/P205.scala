package me.ihainan

object P205 {
  def isIsomorphic(s: String, t: String): Boolean = {
    val m1 = collection.mutable.Map.empty[Char, Char]
    val m2 = collection.mutable.Map.empty[Char, Char]
    if (s.length != t.length) return false
    s.zip(t).foreach { case (c1, c2) =>
      if (m1.isDefinedAt(c1) && m1(c1) != c2) return false
      if (m2.isDefinedAt(c2) && m2(c2) != c1) return false
      m1(c1) = c2
      m2(c2) = c1
    }
    true
  }
}
