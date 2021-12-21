package me.ihainan

object P415 {
  def addStrings(num1: String, num2: String): String = {
    val sb = new StringBuilder()
    var carry = 0
    var (i, j) = (num1.length - 1, num2.length - 1)
    while (i >= 0 || j >= 0) {
      val v1 = if (i < 0) 0 else num1(i) - '0'
      val v2 = if (j < 0) 0 else num2(j) - '0'
      val sum = v1 + v2 + carry
      carry = sum / 10
      sb.append(sum % 10)
      i -= 1
      j -= 1
    }
    if (carry > 0) sb.append(carry)
    sb.reverse.toString
  }
}
