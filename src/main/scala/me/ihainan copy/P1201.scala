package me.ihainan

object P1201 {
  def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)

  def nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int = {
    val lab = a.toLong / gcd(a, b) * b
    val lac = a.toLong / gcd(a, c) * c
    val lbc = b.toLong / gcd(b, c) * c
    val labc = lab / gcd(lab, c) * c

    // println(lab, lac, lbc, labc)

    def nth(x: Long): Long = {
      x / a + x / b + x / c - x / lab - x / lbc - x / lac + x / labc
    }

    @annotation.tailrec
    def find(l: Long, r: Long): Long = {
      if (l > r) -1
      else if (nth(l) >= n.toLong) l
      else {
        val m = (l + r) >>> 1
        if (nth(m) >= n.toLong) find(l + 1, m)
        else find(m + 1, r)
      }
    }

    // println(nth(1999999982), nth(1999999984))
    find(a.min(b).min(c), 1e9.toLong * 2).toInt
  }
}
