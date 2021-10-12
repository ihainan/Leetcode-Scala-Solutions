package me.ihainan

object P29 {
  def divide(dividend: Int, divisor: Int): Int = {
    if (dividend == 0) return 0
    val sign =
      if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) -1
      else 1
    var (a, b, count) = (dividend.toLong.abs, divisor.toLong.abs, 0L)
    while (a >= b) {
      count += 1
      a -= b
    }
    val ans = count * sign
    if (ans > Int.MaxValue || ans < Int.MinValue) Int.MaxValue
    else ans.toInt
  }
}
