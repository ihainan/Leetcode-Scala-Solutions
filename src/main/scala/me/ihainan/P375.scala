package me.ihainan

object P375 {
  def getMoneyAmount(n: Int): Int = {
    val dp = Array.fill(n + 1, n + 1)(Int.MaxValue)
    (1 to n).foreach(i => dp(i)(i) = 0)
    (1 to n).foreach { len =>
      (1 to n - len + 1).foreach { s =>
        val e = s + len - 1
        (s to e).foreach { m =>
          val left = if (m == s) 0 else dp(s)(m - 1)
          val right = if (m == e) 0 else dp(m + 1)(e)
          dp(s)(e) = dp(s)(e).min(m + left.max(right))
        }
      }
    }
    dp(1)(n)
  }
}
