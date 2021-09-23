package me.ihainan

object P551 {
  def checkRecord(s: String): Boolean = {
    var (c1, c2) = (0, 0)
    s.foreach { c =>
      if (c == 'L') c2 += 1 else c2 = 0
      if (c == 'A') c1 += 1
      if (c1 == 2 || c2 == 3) return false
    }
    true
  }
}
