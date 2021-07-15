package me.ihainan

object P557 {
  def reverseWords(s: String): String = {
    val chars = s.toCharArray
    var i = 0
    while (i < s.length) {
      while (i < s.length && s(i) == ' ') i += 1
      val start = i
      while (i < s.length && s(i) != ' ') i += 1
      var (l, r) = (start, i - 1)
      while (l < r) {
        val tmp = chars(l)
        chars(l) = chars(r)
        chars(r) = tmp
        l += 1
        r -= 1
      }
    }
    new String(chars)
  }
}