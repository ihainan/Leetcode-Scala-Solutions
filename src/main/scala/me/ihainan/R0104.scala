package me.ihainan

object R0104 {
  def canPermutePalindrome(s: String): Boolean = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach { c => map(c) = map(c) + 1 }
    map.keys.count(k => map(k) % 2 == 1) <= 1
  }
}
