package me.ihainan

object R0109 {
  def isFlipedString(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) false
    else (s1 + s1).contains(s2)
  }
}
