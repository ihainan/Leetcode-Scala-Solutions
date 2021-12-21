package me.ihainan

object P43Solution2 {
  def add(num1: String, num2: String): String = {
    val sb = new StringBuilder()
    var (i, j) = (num1.length - 1, num2.length - 1)
    var carry = 0
    while (i >= 0 || j >= 0) {
      val v1 = if (i < 0) 0 else num1(i) - '0'
      val v2 = if (j < 0) 0 else num2(j) - '0'
      i -= 1
      j -= 1
      val sum = v1 + v2 + carry
      carry = sum / 10
      sb.append(sum % 10)
    }
    if (carry != 0) sb.append(carry)
    sb.reverse.toString
  }

  def half(num: String): String = {
    val sb = new StringBuilder
    var rest = 0
    num.indices.foreach { i =>
      val n = rest + num(i) - '0'
      if (sb.nonEmpty || n / 2 != 0) sb.append(n / 2)
      rest = (n % 2) * 10
    }
    if (sb.length == 0) "0"
    else sb.toString
  }

  def multiply(num1: String, num2: String): String = {
    if (num1 == "0" || num2 == "0") "0"
    else if (num2 == "1") num1
    else {
      val h = half(num2)
      val mul = multiply(num1, h)
      if ((num2.last - '0') % 2 == 0) add(mul, mul)
      else add(add(mul, mul), num1)
    }
  }
}
