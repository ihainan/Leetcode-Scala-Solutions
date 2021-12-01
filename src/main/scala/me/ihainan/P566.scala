package me.ihainan

object P566 {
  def matrixReshape(
      mat: Array[Array[Int]],
      r: Int,
      c: Int
  ): Array[Array[Int]] = {
    val (m, n) = (mat.length, mat.head.length)
    if (m * n != r * c) return mat
    val ans = Array.fill(r, c)(0)
    (0 until m * n).foreach { count =>
      ans(count / c)(count % c) = mat(count / n)(count % n)
    }
    ans
  }
}
