package me.ihainan

object R0805 {
  def multiply(A: Int, B: Int): Int = {
    if (A == 1) B
    else {
      val half = A >> 1
      val halfSum = multiply(half, B)
      val rest = if ((A & 1) == 1) B else 0
      halfSum + halfSum + rest
    }
  }
}