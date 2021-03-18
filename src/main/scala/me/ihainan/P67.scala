package me.ihainan

object P67 {
  def addBinary(a: String, b: String): String = {
    val sb = new StringBuilder()
    var (carry, i, j) = (0, a.length - 1, b.length - 1)
    while (i >= 0 || j >= 0) {
      val av = if (i == -1) 0 else a(i) - '0'
      val bv = if (j == -1) 0 else b(j) - '0'
      val sum = av + bv + carry
      sb.append(sum % 2)
      carry = sum / 2
      if (i != -1) i -= 1
      if (j != -1) j -= 1
    }
    if (carry != 0) sb.append(carry)
    sb.reverse.toString
  }
}