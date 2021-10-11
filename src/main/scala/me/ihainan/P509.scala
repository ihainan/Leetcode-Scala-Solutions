package me.ihainan

object P509 {
  type Matrix = Array[Array[Int]]

  val MOD = (1e9 + 7).toInt

  def mod(v: Int): Int = (v + MOD) % MOD

  def fib(n: Int): Int = {
    val M = Array(Array(1, 1), Array(1, 0))
    val N = Array(Array(1), Array(0))
    if (n == 0) 0
    else {
      val T = mul(pow(M, n), N)
      T(1)(0)
    }
  }

  def mul(x: Matrix, y: Matrix): Matrix = {
    val (l1, l2, l3) = (x.length, x.head.length, y.head.length)
    val ans = Array.fill(l1, l3)(0)
    (0 until l1).foreach { i =>
      (0 until l3).foreach { j =>
        var sum = 0
        (0 until l2).foreach { k =>
          sum = mod(sum + mod(x(i)(k) * y(k)(j)))
        }
        ans(i)(j) = sum
      }
    }
    ans
  }

  def pow(x: Matrix, n: Int): Matrix = {
    if (n == 1) x
    else {
      val half = pow(x, n >> 1)
      if (n % 2 == 0) mul(half, half)
      else mul(mul(half, half), x)
    }
  }
}
