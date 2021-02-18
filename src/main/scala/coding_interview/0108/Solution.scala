object Solution {
  // O(N * M) / O(1)
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val (m, n) = (matrix.length, matrix.head.length)
    val rowHasZero = (0 until m).exists(i => matrix(i)(0) == 0)
    val columnHasZero = (0 until n).exists(i => matrix(0)(i) == 0)

    (1 until m).foreach { i =>
      (1 until n).foreach { j =>
        if (matrix(i)(j) == 0) {
          matrix(i)(0) = 0
          matrix(0)(j) = 0
        }
      }
    }

     (1 until m).foreach { i =>
      (1 until n).foreach { j =>
        if (matrix(i)(0) == 0 || matrix(0)(j) == 0) matrix(i)(j) = 0
      }
    }

    if (rowHasZero) (0 until m).foreach { i => matrix(i)(0) = 0 }
    if (columnHasZero) (0 until n).foreach { i => matrix(0)(i) = 0 }
  }
}
