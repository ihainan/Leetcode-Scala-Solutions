package me.ihainan

object P190 {
  // you need treat n as an unsigned value
  def reverseBits(x: Int): Int = {
    var sum = 0
    (0 to 15).foreach { i =>
      val j = 31 - i
      val maskI = 1 << i
      val maskJ = 1 << j
      val vi = if ((x & maskI) == maskI) 1 else 0
      val vj = if ((x & maskJ) == maskJ) 1 else 0
      if (vi == 1) sum |= (1 << j)
      if (vj == 1) sum |= (1 << i)
    }
    sum
  }
}