package me.ihainan

object P392Solution2 {
  def isSubsequence(s: String, t: String): Boolean = {
    var j = 0
    s.foreach { c =>
      while (j < t.length && t(j) != c) j += 1
      if (j == t.length) return false
      j += 1
    }
    true
  }
}
