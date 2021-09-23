package me.ihainan

object O16 {
  def myPow(x: Double, n: Int): Double = {
    def pow(x: Double, n: Long): Double = {
      if (n == 0) 1
      else if (n < 0) 1.0 / pow(x, -n)
      else {
        val half = pow(x, n / 2)
        if (n % 2 == 0) half * half
        else half * half * x
      }
    }

    pow(x, n.toLong)
  }
}