package me.ihainan

object P1062 {
  def longestRepeatingSubstring(s: String): Int = {
    (s.length - 1 to 1 by -1).foreach { len =>
      (0 to s.length - len).foreach { start =>
        val str = s.substring(start, start + len)
        if (s.substring(start + 1).contains(str)) return len
      }
    }
    0
  }
}