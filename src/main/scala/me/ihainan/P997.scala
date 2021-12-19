package me.ihainan

object P997 {
  def findJudge(n: Int, trust: Array[Array[Int]]): Int = {
    val in = new Array[Int](n + 1)
    val out = new Array[Int](n + 1)
    trust.foreach { case Array(f, t) => in(t) += 1; out(f) += 1 }
    (1 to n).foreach { i =>
      if (in(i) == n - 1 && out(i) == 0) return i
    }
    -1
  }
}