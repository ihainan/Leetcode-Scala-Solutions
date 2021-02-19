object Solution {
  def isOneEditDistance(s: String, t: String): Boolean = {
    val (l1, l2) = (s.length, t.length)
    if ((l1 - l2).abs > 1 || s == t) false
    else if (l1 > l2) isOneEditDistance(t, s)
    else {
      (0 until l1).foreach { i =>
        if (s(i) != t(i)) {
          if (l1 == l2) return s.substring(i + 1) == t.substring(i + 1)
          else return s.substring(i) == t.substring(i + 1)
        }
      }
      true
    }
  }
}
