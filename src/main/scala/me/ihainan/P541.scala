package me.ihainan

object P541 {
  def reverseStr(s: String, k: Int): String = {
    val chars = s.toCharArray
    (0 until s.length by 2 * k).foreach { i =>
      var (p, q) = (i, (i + k - 1).min(s.length - 1))
      while (p < q) {
        val tmp = chars(p)
        chars(p) = chars(q)
        chars(q) = tmp
        p += 1
        q -= 1
      }
    }
    new String(chars)
  }
}
