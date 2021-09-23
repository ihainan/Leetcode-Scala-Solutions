package me.ihainan

object P1137Solution2 {
  def tribonacci(n: Int): Int = {
    if (n == 0) return 0
    val M = Array(Array(1, 1, 1), Array(1, 0, 0), Array(0, 1, 0))
    val resM = calculate(M, n)
    resM(2)(0) + resM(2)(1)
  }

  def calculate(x: Array[Array[Int]], times: Int): Array[Array[Int]] = {
    if (times == 1) x
    else {
      val half = calculate(x, times / 2)
      if (times % 2 == 0) multiply(half, half) else multiply(multiply(half, half), x)
    }
  }

  def multiply(x: Array[Array[Int]], y: Array[Array[Int]]): Array[Array[Int]] = {
    val ans = Array.fill(3, 3)(0)
    (0 until 3).foreach { i =>
      (0 until 3).foreach { j =>
        ans(i)(j) = x(i)(0) * y(0)(j) + x(i)(1) * y(1)(j) + x(i)(2) * y(2)(j)
      }
    }
    ans
  }
}