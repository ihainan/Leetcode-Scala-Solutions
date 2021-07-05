package me.ihainan

object P248 {
  def compareStr(s1: String, s2: String): Boolean = {
    if (s1.length < s2.length) true
    else if (s1.length > s2.length) false
    else s1 <= s2
  }

  def strobogrammaticInRange(low: String, high: String): Int = {
    var ans = 0
    val choices = Array("00", "11", "88", "69", "96")

    (low.length to high.length).foreach { len =>
      val chars = new Array[Char](len)

      def helper(i: Int, j: Int): Unit = {
        if (i > j) {
          if (len == 1 || chars(0) != '0') {
            val str = new String(chars)
            if (compareStr(low, str) && compareStr(str, high)) ans += 1
          }
        } else {
          choices.foreach { choice =>
            if (!(i == j && choice(0) != choice(1))) {
              chars(i) = choice(0)
              chars(j) = choice(1)
              helper(i + 1, j - 1)
            }
          }
        }
      }

      helper(0, len - 1)
    }
    ans
  }
}