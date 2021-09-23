package me.ihainan

object P1180 {
  def countLetters(s: String): Int = {
    var (i, ans) = (0, 0)
    while (i < s.length) {
      var j = i
      while (j < s.length && s(i) == s(j)) j += 1
      ans += (j - i + 1) * (j - i) / 2
      i = j
    }
    ans
  }
}