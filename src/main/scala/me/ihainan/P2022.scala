package me.ihainan

object P2022 {
  def construct2DArray(
      original: Array[Int],
      m: Int,
      n: Int
  ): Array[Array[Int]] = {
    if (original.length != m * n) return Array.empty[Array[Int]]
    val ans = Array.fill(m, n)(0)
    original.indices.foreach { i =>
      val r = i / n
      val c = i % n
      ans(r)(c) = original(i)
    }
    ans
  }
}
