package me.ihainan

object P371 {
  def getSum(a: Int, b: Int): Int = {
    var (aa, bb) = (a, b)
    while (true) {
      val sum = aa ^ bb
      val carry = aa & bb
      if (carry == 0) return sum
      else {
        aa = sum
        bb = carry << 1
      }
    }
    0
  }
}