package me.ihainan

object P91 {
  def isValid(s: String): Boolean = {
    s(0) != '0' && s.toInt >= 1 && s.toInt <= 26
  }

  def numDecodings(s: String): Int = {
    val dp = new Array[Int](s.length + 1)
    dp(0) = 1
    (1 to s.length).map { i =>
      if (s(i - 1) == '0') dp(i) = 0
      else dp(i) = dp(i - 1)
      if (i >= 2 && isValid(s.substring(i - 2, i))) dp(i) += dp(i - 2)
      if (dp(i) == 0 && dp(i - 1) == 0) return 0
    }
    dp.last
  }
}
