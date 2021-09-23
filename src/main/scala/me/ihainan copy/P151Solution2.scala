package me.ihainan

object P151Solution2 {
  def reverseWords(s: String): String = {
    var (i, j) = (s.length - 1, s.length - 1)
    val sb = new StringBuilder
    while (i >= 0) {
      while (i >= 0 && s(i) != ' ') i -= 1
      if (sb.nonEmpty) sb.append(" ")
      sb.append(s.substring(i + 1, j + 1))
      while (i >= 0 && s(i) == ' ') i -= 1
      j = i
    }
    sb.toString
  }
}