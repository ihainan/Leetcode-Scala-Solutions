package me.ihainan

object R0107 {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val n = matrix.length
    (0 to (n - 1) / 2).foreach { i =>
      (n - 1 - i to i + 1 by -1).foreach { j =>
        val tmp = matrix(i)(j)
        matrix(i)(j) = matrix(n - 1 - j)(i)
        matrix(n - 1 - j)(i) = matrix(n - 1 - i)(n - 1 - j)
        matrix(n - 1 - i)(n - 1 - j) = matrix(j)(n - 1 - i)
        matrix(j)(n - 1 - i) = tmp
      }
    }
  }
}
