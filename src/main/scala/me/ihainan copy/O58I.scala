package me.ihainan

object O58I {
  def reverseWords(s: String): String = {
    val sb = new StringBuilder()
    var i = s.length - 1
    while (i >= 0) {
      while (i >= 0 && s(i) == ' ') i -= 1
      var j = i
      while (j >= 0 && s(j) != ' ') j -= 1
      if (i >= 0) {
        if (sb.nonEmpty) sb.append(" ")
        sb.append(s.substring(j + 1, i + 1))
      }
      i = j
    }
    sb.toString
  }
}