package me.ihainan

object R0102 {
  def CheckPermutation(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) false
    else {
      val m1 = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
      val m2 = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
      s1.foreach { c => m1(c) = m1(c) + 1 }
      s2.foreach { c => m2(c) = m2(c) + 1 }
      !m1.keys.exists { k => m2(k) != m1(k) }
      !m2.keys.exists { k => m2(k) != m1(k) }
    }
  }
}
