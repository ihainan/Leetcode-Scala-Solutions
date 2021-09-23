package me.ihainan

object P878Solution3 {
  val MOD = (1e9 + 7).toInt
  def nthMagicalNumber(n: Int, a: Int, b: Int): Int = {
    def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    val lcm = a / gcd(a, b) * b

    @annotation.tailrec
    def find(l: Long, r: Long): Long = {
      if (l > r) -1
      else if (l / a - l / lcm + l / b >= n.toLong) l
      else {
        val m = (l + r) >>> 1
        if (m / a + m / b - m / lcm >= n.toLong) find(l + 1, m)
        else find(m + 1, r)
      }
    }

    (find(a.min(b), 1e15.toLong) % MOD).toInt
  }
}
