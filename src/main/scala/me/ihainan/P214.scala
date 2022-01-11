package me.ihainan

object P214 {
  def shortestPalindrome(s: String): String = {
    if (s.length <= 1) return s
    (s.length - 1 to 0 by -1).foreach { end =>
      val mid = end / 2
      if (end % 2 == 0) {
        if ((0 to mid).forall(i => s(mid - i) == s(mid + i))) {
          return s.substring(end + 1, s.length).reverse + s
        }
      } else {
        if (
          s(mid) == s(mid + 1) && (0 to mid)
            .forall(i => s(mid - i) == s(mid + 1 + i))
        ) {
          return s.substring(end + 1, s.length).reverse + s
        }
      }
    }
    s.substring(1, s.length).reverse + s
  }
}
