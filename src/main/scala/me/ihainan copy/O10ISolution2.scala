package me.ihainan

object O10ISolution2 {
  type Matrix = Array[Array[Int]]

  val MOD = 1000000007
  def fib(n: Int): Int = {
    val x = Array(Array(1, 1), Array(1, 0))
    val y = Array(Array(1), Array(0))
    if (n == 0) 0
    else {
      val mul = pow(x, n)
      calculate(mul, y)(1)(0)
    }
  }

  def calculate(x: Matrix, y: Matrix): Matrix = {
    val (l1, l2, l3) = (x.length, y.length, y.head.length)
    val ans = Array.fill(l1, l3)(0)
    (0 until l1).foreach { i =>
      (0 until l3).foreach { j =>
        var sum = 0L
        (0 until l2).foreach { k =>
          sum = (sum + (x(i)(k).toLong * y(k)(j)) % MOD) % MOD
        }
        ans(i)(j) = sum.toInt
      }
    }
    ans
  }

  def pow(x: Matrix, n: Int): Matrix = {
    if (n == 1) x
    else {
      val half = pow(x, n >> 1)
      if (n % 2 == 0) calculate(half, half)
      else calculate(calculate(half, half), x)
    }
  }
}
