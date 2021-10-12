package me.ihainan

object P29Solution2 {
  def divide(dividend: Int, divisor: Int): Int = {
    if (dividend == 0) return 0
    val sign =
      if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) -1
      else 1
    val (a, b) = (dividend.toLong.abs, divisor.toLong.abs)

    def mul(x: Long, y: Long): Long = {
      if (y == 1) x
      else {
        val h = mul(x, y >>> 1)
        val s = h + h
        if ((y & 1) == 0) s else s + x
      }
    }

    // find the first value m that m * b > a
    @annotation.tailrec
    def find(l: Long, r: Long): Long = {
      if (l > r) Int.MaxValue
      else if (mul(l, b) > a) l
      else {
        val m = (l + r) >>> 1
        if (mul(m, b) > a) find(l + 1, m)
        else find(m + 1, r)
      }
    }

    val ans = (find(1, Int.MaxValue.toLong + 2) - 1) * sign
    if (ans > Int.MaxValue || ans < Int.MinValue) Int.MaxValue else ans.toInt
  }
}
