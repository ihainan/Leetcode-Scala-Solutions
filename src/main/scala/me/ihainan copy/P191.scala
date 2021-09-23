package me.ihainan

object P191 {
  // you need treat n as an unsigned value
  def hammingWeight(n: Int): Int = {
    var (ans, num) = (0, n)
    while (num != 0) {
      num = num & (num - 1)
      ans += 1
    }
    ans
  }
}