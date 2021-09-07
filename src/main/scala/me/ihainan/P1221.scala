package me.ihainan

object P1221 {
  def balancedStringSplit(s: String): Int = {
    var count = 0
    s.count { c =>
      if (c == 'L') count += 1
      if (c == 'R') count -= 1
      count == 0
    }
  }
}