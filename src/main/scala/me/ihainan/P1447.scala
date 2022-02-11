package me.ihainan

object P1447 {
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  def simplifiedFractions(n: Int): List[String] = {
    val ans = collection.mutable.ListBuffer.empty[String]
    (1 to n - 1).foreach { i =>
      (i + 1 to n).foreach { j =>
        if (gcd(j, i) == 1) {
          ans += i + "/" + j
        }
      }
    }
    ans.toList
  }
}
