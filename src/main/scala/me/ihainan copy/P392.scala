package me.ihainan

object P392 {
  def isSubsequence(s: String, t: String): Boolean = {
    if (s.length == 0) return true
    else if (t.length == 0) return false

    val dp = Array.fill(t.length, 26)(-1)
    dp(t.length - 1)(t.last - 'a') = t.length - 1

    (t.length - 2 to 0 by -1).foreach { i =>
      (0 until 26).foreach { j =>
        if (t(i) - 'a' == j) dp(i)(j) = i
        else dp(i)(j) = dp(i + 1)(j)
      }
    }

    var current = 0
    s.foreach { c =>
      if (current >= t.length || dp(current)(c - 'a') == -1) return false
      else current = dp(current)(c - 'a') + 1
    }

    true
  }
}
