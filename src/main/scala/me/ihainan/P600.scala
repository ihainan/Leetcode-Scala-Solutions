package me.ihainan

object P600 {
  def findIntegers(n: Int): Int = {
    val len = n.toBinaryString.length
    val dp = new Array[Int](len + 1)
    dp(0) = 1
    dp(1) = 1
    (2 to len).foreach(i => dp(i) = dp(i - 1) + dp(i - 2))

    var (ans, num, depth) = (0, 0, len + 1)
    while (depth > 1) {
      if ((((num << 1) + 1) << (depth - 2)) <= n) {
        ans += dp(depth - 1)
        depth -= 2
        num = (num << 2) + 2
      } else {
        depth -= 1
        num = num << 1
      }
    }

    ans + 1
  }
}
