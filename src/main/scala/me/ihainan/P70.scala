package me.ihainan

object P70 {
  type Matrix = Array[Array[Int]]

  val MOD = (1e9 + 7).toInt

  def mod(x: Int) = x

  def climbStairs(n: Int): Int = {
    if (n == 1) return 1
    val M = Array(Array(1, 1), Array(1, 0))
    val N = Array(Array(2), Array(1))
    val T = mul(pow(M, n - 1), N)
    T(1)(0)
  }

  def mul(x: Matrix, y: Matrix): Matrix = {
    val (l1, l2, l3) = (x.length, y.length, y.head.length)
    val ans = Array.fill(l1, l3)(0)
    (0 until l1).foreach { i =>
      (0 until l3).foreach { j =>
        var sum = 0
        (0 until l2).foreach(k => sum = mod(sum + mod(x(i)(k) * y(k)(j))))
        ans(i)(j) = sum
      }
    }
    ans
  }

  def pow(x: Matrix, n: Int): Matrix = {
    if (n == 1) x
    else {
      val half = pow(x, n >>> 1)
      val product = mul(half, half)
      if ((n & 1) == 0) product else mul(product, x)
    }
  }
}
