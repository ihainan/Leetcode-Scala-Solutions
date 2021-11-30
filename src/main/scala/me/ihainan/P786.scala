package me.ihainan

object P786 {
  def kthSmallestPrimeFraction(arr: Array[Int], k: Int): Array[Int] = {
    val nums =
      for {
        i <- arr.indices
        j <- i + 1 until arr.length
      } yield (Array(arr(i), arr(j)))
    nums.sortBy { case Array(v1, v2) => v1 * 1.0 / v2 }.apply(k - 1)
  }
}
