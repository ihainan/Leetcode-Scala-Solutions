package me.ihainan

object P66Solution2 {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var carry = 1
    (digits.length - 1 to 0 by -1).foreach { i =>
      val sum = digits(i) + carry
      digits(i) = sum % 10
      carry = sum / 10
      if (carry == 0) return digits
    }
    1 +: digits
  }
}