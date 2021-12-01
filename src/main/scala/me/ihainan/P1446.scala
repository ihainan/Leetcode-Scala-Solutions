package me.ihainan

object P1446 {
  def maxPower(s: String): Int = {
    var ans = 0
    var count = 1
    s.indices.foreach { i =>
      if (i > 0 && s(i) == s(i - 1)) count += 1
      else count = 1
      ans = ans.max(count)
    }
    ans
  }
}
