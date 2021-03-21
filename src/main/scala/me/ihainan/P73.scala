package me.ihainan

object P73 {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    if (matrix.length > 0 && matrix.head.length > 0) {
      val (m, n) = (matrix.length, matrix.head.length)
      val rowHasZero = (0 until n).exists(j => matrix(0)(j) == 0)
      val columnHasZero = (0 until m).exists(i => matrix(i)(0) == 0)
      (1 until m).foreach { i =>
        (1 until n).foreach { j =>
          if (matrix(i)(j) == 0) {
            matrix(0)(j) = 0
            matrix(i)(0) = 0
          }
        }
      }

      (1 until m).foreach { i =>
        (1 until n).foreach { j =>
          if (matrix(i)(0) == 0 || matrix(0)(j) == 0) {
            matrix(i)(j) = 0
          }
        }
      }

      if (rowHasZero) (0 until n).foreach(j => matrix(0)(j) = 0)
      if (columnHasZero) (0 until m).foreach(i => matrix(i)(0) = 0)
    }
  }
}