package me.ihainan

object P821 {
  def shortestToChar(s: String, c: Char): Array[Int] = {
    val ans = Array.fill(s.length)(Int.MaxValue)
    var (p1, p2) = (-1, -1)
    (0 until s.length).foreach { i =>
      val j = s.length - i - 1
      if (s(i) == c) p1 = i
      if (s(j) == c) p2 = j
      if (p1 != -1) ans(i) = ans(i).min(i - p1)
      if (p2 != -1) ans(j) = ans(j).min(p2 - j)
    }
    ans
  }
}