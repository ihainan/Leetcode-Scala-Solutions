package me.ihainan

object P50 {
  def myPow(x: Double, n: Int): Double = {
    if (n < 0) 1.0 / pow(x, n.toLong.abs) else pow(x, n.toLong)
  }

  def pow(x: Double, n: Long): Double = {
    if (n == 0) 1
    else if (n == 1) x
    else {
      val v = pow(x, n / 2)
      if (n % 2 == 0) v * v
      else v * v * x
    }
  }
}