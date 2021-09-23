package me.ihainan

object R1605Better {
  def trailingZeroes(n: Int): Int = {
    var ans = 0
    var d = 5L
    while (d <= n) {
      ans += n / d.toInt
      d *= 5
    }
    ans
  }
}