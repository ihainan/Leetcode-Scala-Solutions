package me.ihainan

object P186Solution2 {
  def reverseWords(s: Array[Char]): Unit = {
    def reverse(l: Int, r: Int): Unit = {
      var (i, j) = (l, r)
      while (i < j) {
        val tmp = s(i)
        s(i) = s(j)
        s(j) = tmp
        i += 1
        j -= 1
      }
    }

    var (i, j) = (s.length - 1, s.length - 1)
    while (i >= 0) {
      while (i >= 0 && s(i) != ' ') i -= 1
      reverse(i + 1, j)
      while (i >= 0 && s(i) == ' ') i -= 1
      j = i
    }
    reverse(0, s.length - 1)
  }
}