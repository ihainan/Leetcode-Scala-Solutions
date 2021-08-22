package me.ihainan

object P443 {
  def compress(chars: Array[Char]): Int = {
    var (i, k) = (0, 0)
    while (i < chars.length) {
      chars(k) = chars(i)
      var j = i + 1
      while (j < chars.length && chars(i) == chars(j)) j += 1
      val len = j - i
      val lenStr = len.toString
      if (len == 1) k += 1
      else {
        lenStr.indices.foreach { l => chars(k + l + 1) = lenStr(l) }
        k += 1 + lenStr.length
      }
      i = j
    }
    k
  }
}