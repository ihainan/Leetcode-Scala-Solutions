package me.ihainan

object P306 {
  def isAdditiveNumber(num: String): Boolean = {
    def add(s1: Int, e1: Int, s2: Int, e2: Int): String = {
      val sb = new StringBuilder()
      var carry = 0
      (0 to (e1 - s1).max(e2 - s2)).foreach { i =>
        val v1 = if (e1 - i < s1) 0 else num(e1 - i) - '0'
        val v2 = if (e2 - i < s2) 0 else num(e2 - i) - '0'
        val sum = v1 + v2 + carry
        sb.append(sum % 10)
        carry = sum / 10
      }
      if (carry != 0) sb.append(carry)
      sb.reverse.toString
    }

    def solve(s1: Int, e1: Int, s2: Int, e2: Int): Boolean = {
      if (e2 == num.length - 1) return true
      val sum = add(s1, e1, s2, e2)
      if (num.length - 1 - e2 < sum.length) false
      else {
        if (sum.indices.exists { i => num(e2 + 1 + i) != sum(i) }) false
        else solve(s2, e2, e2 + 1, e2 + sum.length)
      }
    }

    num.indices.exists { i =>
      (i + 1 until num.length - 1).exists { j =>
        (j == i + 1 || num(i + 1) != '0') && solve(0, i, i + 1, j)
      }
    }
  }
}
