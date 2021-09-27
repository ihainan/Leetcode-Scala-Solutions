package me.ihainan

object P639 {
  val MOD = (1e9 + 7).toInt

  def mod(x: Long) = (x + MOD) % MOD

  def isValid(s: String):Boolean = {
    s(0) != '0' && s.toInt >= 1 && s.toInt <= 26
  }

  def numDecodings(s: String): Int = {
    val dp = new Array[Long](s.length + 1)
    dp(0) = 1
    if (s(0) == '*') dp(1) = 9 else if (s(0) != '0') dp(1) = 1

    (2 to s.length).foreach { i =>
      dp(i) = 
        if (s(i - 1) == '0') 0
        else mod(dp(i - 1) * (if (s(i - 1) == '*') 9 else 1))
      val (c1, c2) = (s(i - 2), s(i - 1))
      if (c2 == '*') {
        if (c1 == '*') dp(i) = mod(dp(i) + mod(dp(i - 2) * 15))
        else dp(i) = mod(dp(i) + mod(dp(i - 2) * (1 to 9).count { num => isValid("" + c1 + num) } ))
      } else {
        if (c1 == '*') dp(i) = mod(dp(i) + mod(dp(i - 2) * (1 to 2).count { num => isValid("" + num + c2) } ))
        else if (isValid(s.substring(i - 2, i))) dp(i) = mod(mod(dp(i) + dp(i - 2)))
      }
    }

    dp.last.toInt
  }
}