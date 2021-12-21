package me.ihainan

object P91 {
  def numDecodings(s: String): Int = {
    val map = (1 to 26).map(i => i.toString -> ('A' + i - 1).toChar).toMap
    val dp = new Array[Int](s.length + 1)
    if (s(0) == '0') return 0
    dp(0) = 1
    (1 until dp.length).foreach { i =>
      if (map.isDefinedAt(s.substring(i - 1, i))) dp(i) += dp(i - 1)
      if (i != 1 && map.isDefinedAt(s.substring(i - 2, i))) dp(i) += dp(i - 2)
    }
    dp.last
  }
}
