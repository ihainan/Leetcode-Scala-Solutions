package me.ihainan

object P600 {
  def findIntegers(n: Int): Int = {
    val len = n.toBinaryString.length
    val dp = new Array[Int](len + 1)
    dp(0) = 1
    dp(1) = 1
    (2 to len).foreach(i => dp(i) = dp(i - 1) + dp(i - 2))

    var num = 0
    var ans = 0
    var i = len + 1
    while (i >= 0) {
      if (i == 0) {
        ans += 1
        i -= 1
      } else if ((((num << 1) + 1) << (i - 2)) > n) {
        i -= 1
        num = num << 1
      } else {
        ans += dp(i - 1)
        i -= 2
        num = ((num << 1) + 1) << 1
      }
    }

    ans
  }
}
