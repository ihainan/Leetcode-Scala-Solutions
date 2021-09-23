package me.ihainan

object P186 {
  def reverseWords(s: Array[Char]): Unit = {
    val ans = collection.mutable.ArrayBuffer.empty[Char]
    var (i, j) = (s.length - 1, s.length - 1)
    while (i >= 0) {
      while (i >= 0 && s(i) != ' ') i -= 1
      if (ans.length != 0) ans += ' '
      (i + 1 to j).foreach { k => ans += s(k) }
      while (i >= 0 && s(i) == ' ') i -= 1
      j = i
    }
    System.arraycopy(ans.toArray, 0, s, 0, ans.length)
  }
}