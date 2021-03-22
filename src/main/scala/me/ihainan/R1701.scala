package me.ihainan

object R1701 {
  def add(a: Int, b: Int): Int = {
    var (num1, num2) = (a, b)
    while (true) {
      val sum = num1 ^ num2
      val carry = (num1 & num2) << 1
      if ((sum & carry) == 0) return sum | carry
      num1 = sum
      num2 = carry
    }
    -1
  }
}