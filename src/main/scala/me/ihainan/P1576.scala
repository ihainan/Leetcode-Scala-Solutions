package me.ihainan

object P1576 {
  def modifyString(s: String): String = {
    val chars = s.toCharArray
    s.indices.foreach { i =>
      if (s(i) == '?') {
        val c = ('a' to 'z').collectFirst { 
          case c if (i == 0 || c != chars(i - 1)) && (i == s.length - 1 || c != chars(i + 1)) => c
        }.get
        chars(i) = c
      }
    }
    new String(chars)
  }
}