package me.ihainan

object O14ISolution2 {
  def cuttingRope(n: Int): Int = {
    if (n <= 3) n - 1
    else {
      val x = n / 3
      val m = n % 3
      if (m == 0) math.pow(3, x).toInt
      else if (m == 1) math.pow(3, x - 1).toInt * 4
      else math.pow(3, x - 1).toInt * 6
    }
  }
}