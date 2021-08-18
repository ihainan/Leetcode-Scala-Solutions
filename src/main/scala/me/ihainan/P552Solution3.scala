package me.ihainan

object P552Solution3 {
  val MOD = 1000000007

  def modSum(nums: Int*): Int = {
    var sum = 0
    nums.map { num => sum = (sum + num) % MOD }
    sum
  }

  def checkRecord(n: Int): Int = {
    val x = Array(
      Array(1, 1, 1, 0, 0, 0),
      Array(1, 0, 0, 0, 0, 0),
      Array(0, 1, 0, 0, 0, 0),
      Array(1, 1, 1, 1, 1, 1),
      Array(0, 0, 0, 1, 0, 0),
      Array(0, 0, 0, 0, 1, 0)
    )

    val y = Array(Array(1), Array(1), Array(0), Array(1), Array(0), Array(0))

    if (n == 1) 3
    else {
      val c = calculate(x, n - 1)
      modSum(multiply(calculate(x, n - 1), y).flatten: _*)
    }
  }

  def calculate(x: Array[Array[Int]], n: Int): Array[Array[Int]] = {
    if (n == 1) x
    else {
      val half = calculate(x, n / 2)
      val mul = multiply(half, half)
      if (n % 2 == 0) mul else multiply(mul, x)
    }
  }

  def multiply(
      x: Array[Array[Int]],
      y: Array[Array[Int]]
  ): Array[Array[Int]] = {
    val (m, n) = (x.length, y.head.length)
    val ans = Array.fill(m, n)(0)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        ans(i)(j) = modSum(
          (0 until y.length).map(k =>
            ((x(i)(k).toLong * y(k)(j)) % MOD).toInt
          ): _*
        )
      }
    }
    ans
  }
}
