package me.ihainan

object P43 {
  def multiply(num1: String, num2: Int, zeros: String): String = {
    val sb = new StringBuilder(zeros)
    var carry = 0
    (num1.length - 1 to 0 by -1).foreach { i =>
      val num = num1(i) - '0'
      val sum = num * num2 + carry
      carry = sum / 10
      sb.append(sum % 10)
    }
    if (carry != 0) sb.append(carry)
    sb.toString
  }

  def add(num1: String, num2: String): String = {
    val sb = new StringBuilder()
    var carry = 0
    (0 until (num1.length.max(num2.length))).foreach { i =>
      val v1 = if (i >= num1.length) 0 else num1(i) - '0'
      val v2 = if (i >= num2.length) 0 else num2(i) - '0'
      val sum = v1 + v2 + carry
      carry = sum / 10
      sb.append(sum % 10)
    }
    if (carry != 0) sb.append(carry)
    sb.toString
  }

  def multiply(num1: String, num2: String): String = {
    var sum = "0"
    num2.indices.foreach { i =>
      val mul = multiply(num1, num2(i) - '0', "0" * (num2.length - i - 1))
      sum = add(sum, mul)
    }

    val ans = sum.reverse
    var i = ans.length - 1
    while (i >= 0 && ans(i) == '0') i -= 1
    if (i == -1) "0" else ans
  }
}
