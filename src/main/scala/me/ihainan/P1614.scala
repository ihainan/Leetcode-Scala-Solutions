package me.ihainan

object P1614 {
  def maxDepth(s: String): Int = {
    var ans = 0
    var current = 0
    s.foreach { c =>
      if (c == '(') current += 1
      else if (c == ')') current -= 1
      ans = ans.max(current)
    }
    ans
  }
}
