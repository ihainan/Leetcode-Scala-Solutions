package me.ihainan

object P66 {
  def plusOne(digits: Array[Int]): Array[Int] = {
    val ans = collection.mutable.ArrayBuffer.empty[Int]
    var carry = 1
    (digits.length - 1 to 0 by -1).foreach { i =>
      val sum = digits(i) + carry
      ans += sum % 10
      carry = sum / 10
    }
    if (carry > 0) ans += 1
    ans.toArray.reverse
  }
}