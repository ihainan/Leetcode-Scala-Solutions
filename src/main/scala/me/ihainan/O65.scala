package me.ihainan

object O65 {
  def add(a: Int, b: Int): Int = {
    var ans = 0
    var carry = 0
    var bit = 0
    (0 until 32).foreach { i =>
      val mask = 1 << i
      val v1 = if ((a & mask) == mask) 1 else 0
      val v2 = if ((b & mask) == mask) 1 else 0
      if (v1 == 0 && v2 == 0) {
        bit = carry
        carry = 0
      } else if (v1 == 1 && v2 == 1) {
        if (carry == 0) bit = 0 else bit = 1
        carry = 1
      } else if (carry == 1) {
        carry = 1
        bit = 0
      } else {
        carry = 0
        bit = 1
      }
      ans |= (bit << i)
    }
    ans
  }
}