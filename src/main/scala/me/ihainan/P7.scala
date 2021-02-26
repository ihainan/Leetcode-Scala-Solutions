package me.ihainan

object P7 {
  def reverse(x: Int): Int = {
    var ans = 0
    var num = x
    while (num != 0) {
      val r = num % 10
      if (ans > Int.MaxValue / 10 || (ans == Int.MaxValue && r > 7)) return 0
      if (ans < Int.MinValue / 10 || (ans == Int.MinValue && r < -8)) return 0
      ans = ans * 10 + r
      num /= 10
    }
    ans
  }
}