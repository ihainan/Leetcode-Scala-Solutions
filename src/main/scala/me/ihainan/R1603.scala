package me.ihainan

object R1603 {
  def calculateT1(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, x4: Int, y4: Int): Double = {
    (x1 * (y4 - y3) - x3 * (y4 - y3) - y1 * (x4 - x3) + y3 * (x4 - x3)) * 1.0 / ((y2 - y1) * (x4 - x3) - (x2 - x1) * (y4 - y3))
  }

  def calculateT2(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, x4: Int, y4: Int): Double = {
    (y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1) + x1 * (y2 - y1)) * 1.0 / ((x4 - x3) * (y2 - y1) - (y4 - y3) * (x2 - x1))
  }

  def isParallel(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, x4: Int, y4: Int): Boolean = {
    (y2 - y1) * (x4 - x3) == (x2 - x1) * (y4 - y3)
  }

  def isInLine(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Boolean = {
    if ((x3 - x1) * (y2 - y1) != (x2 - x1) * (y3 - y1)) false
    else if (y1 == y2) x3 >= x1.min(x2) && x3 <= x1.max(x2)
    else if (x1 == x2) y3 >= y1.min(y2) && y3 <= y1.max(y2)
    else {
      val t = (x3 - x1) * 1.0 / (x2 - x1)
      if (t < 0 || t > 1) false
      else x3 >= x1.min(x2) && x3 <= x1.max(x2) && y3 >= y1.min(y2) && y3 <= y1.max(y2)
    }
  }

  def update(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, ans: Array[Double]): Unit = {
    if (isInLine(x1, y1, x2, y2, x3, y3)) {
      if (x3 < ans(0) || (x3 == ans(0) && y3 < ans(1))) {
        ans(0) = x3
        ans(1) = y3
      }
    }
  }

  def intersection(s1: Array[Int], e1: Array[Int], s2: Array[Int], e2: Array[Int]): Array[Double] = {
    val (x1, y1, x2, y2) = (s1(0), s1(1), e1(0), e1(1))
    val (x3, y3, x4, y4) = (s2(0), s2(1), e2(0), e2(1))
    if (isParallel(x1, y1, x2, y2, x3, y3, x4, y4)) {
      val ans = Array(Double.MaxValue, Double.MaxValue)
      update(x1, y1, x2, y2, x3, y3, ans)
      update(x1, y1, x2, y2, x4, y4, ans)
      update(x3, y3, x4, y4, x1, y1, ans)
      update(x3, y3, x4, y4, x2, y2, ans)
      if (ans(0) == Double.MaxValue) Array()
      else ans
    } else {
      val t1 = calculateT1(x1, y1, x2, y2, x3, y3, x4, y4)
      val t2 = calculateT2(x1, y1, x2, y2, x3, y3, x4, y4)
      println(t1, t2)
      if (t1 < 0 || t1 > 1 || t2 < 0 || t2 > 1) Array()
      else {
        val x = x1 + t1 * (x2 - x1)
        val y = y1 + t1 * (y2 - y1)
        Array(x, y)
      }
    }
  }
}