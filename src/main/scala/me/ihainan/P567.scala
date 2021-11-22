package me.ihainan

object P567 {
  def checkInclusion(s1: String, s2: String): Boolean = {
    val m1 = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    val m2 = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s1.foreach(c => m1(c) += 1)
    var j = 0
    s2.indices.foreach { i =>
      if (m1(s2(i)) == 0) {
        m2.clear
        j = i + 1
      } else {
        m2(s2(i)) += 1
        if (i - j + 1 == s1.length) {
          if (m1.size == m2.size && m1.sameElements(m2)) return true
          m2(s2(j)) -= 1
          j += 1
        }
      }
    }

    false
  }
}
