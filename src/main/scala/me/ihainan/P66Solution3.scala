package me.ihainan

object P66Solution3 {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var i = digits.length - 1
    while (i >= 0) {
      if (digits(i) != 9) {
        digits(i) += 1
        return digits
      }
      digits(i) = 0
      i -= 1
    }
    val newDigits = new Array[Int](digits.length + 1)
    newDigits(0) = 1
    newDigits
  }
}
