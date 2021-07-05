package me.ihainan

object P266 {
  def canPermutePalindrome(s: String): Boolean = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach { c => map(c) = map(c) + 1 }
    map.count { case (k, v) => v % 2 == 1 } <= 1
  }
}