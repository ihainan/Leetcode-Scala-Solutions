package me.ihainan

object P1314 {
  def matrixBlockSum(mat: Array[Array[Int]], k: Int): Array[Array[Int]] = {
    val (m, n) = (mat.length, mat.head.length)
    val sums = Array.fill(m, n)(0)

    def getMatrixSum(i: Int, j: Int): Int = {
      if (i < 0 || j < 0) 0
      else sums(i)(j)
    }

    (0 until m).foreach { i =>
      var sum = 0
      (0 until n).foreach { j =>
        sum += mat(i)(j)
        if (i == 0) sums(i)(j) = sum
        else sums(i)(j) = sums(i - 1)(j) + sum
      }
    }

    (0 until m).map { i =>
      (0 until n).map { j =>
        val x1 = 0.max(i - k)
        val y1 = 0.max(j - k)
        val x2 = (m - 1).min(i + k)
        val y2 = (n - 1).min(j + k)
        getMatrixSum(x2, y2) - getMatrixSum(x1 - 1, y2) - getMatrixSum(
          x2,
          y1 - 1
        ) + getMatrixSum(x1 - 1, y1 - 1)
      }.toArray
    }.toArray
  }
}
