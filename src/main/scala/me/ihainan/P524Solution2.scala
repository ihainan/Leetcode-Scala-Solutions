package me.ihainan

object P524Solution2 {
  def findLongestWord(s: String, dictionary: List[String]): String = {
    val dp = Array.fill(s.length, 26)(-1)
    dp(s.length - 1)(s.last - 'a') = s.length - 1
    (s.length - 2 to 0 by -1).foreach { i =>
      (0 until 26).foreach { j =>
        if (j == s(i) - 'a') dp(i)(j) = i
        else dp(i)(j) = dp(i + 1)(j)
      }
    }

    def isSubstring(s2: String): Boolean = {
      if (s.length < s2.length) return false
      var current = 0
      s2.foreach { c =>
        if (current >= s.length || dp(current)(c - 'a') == -1) return false
        else current = dp(current)(c - 'a') + 1
      }
      true
    }

    dictionary.sortWith { case (v1, v2) =>
      if (v1.length != v2.length) v1.length > v2.length
      else v1 < v2
    }.collectFirst { 
      case s2 if isSubstring(s2) => s2
    }.getOrElse("")
  }
}