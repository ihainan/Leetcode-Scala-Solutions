package me.ihainan

object P151Solution2 {
  def reverseWords(s: String): String = {
    val ss = s.trim
    var (i, j) = (ss.length - 1, ss.length - 1)
    val strs = collection.mutable.ArrayBuffer.empty[String]
    while (i >= 0) {
      while (i >= 0 && ss(i) != ' ') i -= 1
      strs += ss.substring(i + 1, j + 1)
      while (i >= 0 && ss(i) == ' ') i -= 1
      j = i
    }
    strs.mkString(" ")
  }
}