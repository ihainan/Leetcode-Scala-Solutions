package me.ihainan

object P878Solution2 {
  val MOD = (1e9 + 7).toInt

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  def nthMagicalNumber(n: Int, a: Int, b: Int): Int = {
    val lcm = (a / gcd(a, b) * b).toLong
    val loopSize = lcm / a + lcm / b - 1
    val q = n / loopSize
    val r = n % loopSize

    if (r == 0) (lcm * q % MOD).toInt
    else {
      var (x, y) = (lcm / a * q, lcm / b * q)
      var ans = 0L
      (0 until r.toInt).foreach { _ =>
        ans = ((x + 1) * a).min((y + 1) * b)
        if (ans == (x + 1) * a) x += 1
        if (ans == (y + 1) * b) y += 1
      }
      (ans % MOD).toInt
    }
  }
}
