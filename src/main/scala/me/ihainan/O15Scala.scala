package me.ihainan

object O15Scala {
  // you need treat n as an unsigned value
  def hammingWeight(n: Int): Int = {
    var nn = n
    var ans = 0
    while (nn != 0) {
      nn = nn & (nn - 1)
      ans += 1
    }
    ans
  }
}