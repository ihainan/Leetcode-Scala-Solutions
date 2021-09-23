package me.ihainan

object R0508 {
  def drawLine(length: Int, w: Int, x1: Int, x2: Int, y: Int): Array[Int] = {
    val ans = Array.fill(length)(0)
    (x1 to x2).foreach { x =>
      val i = y * (w / 32) + x / 32
      val j = 31 - x % 32
      ans(i) = ans(i) | (1 << j)
    }

    ans
  }
}