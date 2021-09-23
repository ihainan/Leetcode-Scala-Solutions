package me.ihainan

object P313 {
  def nthSuperUglyNumber(n: Int, primes: Array[Int]): Int = {
    val dp = new Array[Int](n)
    dp(0) = 1
    val indices = Array.fill(primes.length)(0)
    (1 until n).foreach { i =>
      val min = primes.indices.map { j => dp(indices(j)) * primes(j) }.min
      primes.indices.foreach { j =>
        if (min == dp(indices(j)) * primes(j)) indices(j) += 1
      }
      dp(i) = min
    }
    dp.last
  }
}