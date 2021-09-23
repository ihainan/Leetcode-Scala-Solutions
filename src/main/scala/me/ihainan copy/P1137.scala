package me.ihainan

object P1137 {
  def tribonacci(n: Int): Int = {
    var (t1, t2, t3) = (0, 1, 1)
    (1 to n).foreach { _ =>
      val (x1, x2, x3) = (t1, t2, t3)
      t1 = x2
      t2 = x3
      t3 = x1 + x2 + x3
    }
    t1
  }
}