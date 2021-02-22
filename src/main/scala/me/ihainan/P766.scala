package me.ihainan

object P766 {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    val (m, n) = (matrix.length, matrix.head.length)
    val arr = (0 until m).map(i => (i, 0)).toArray ++ (1 until n).map(j => (0, j)).toArray
    arr.foreach { case (i, j) =>
      var (k, l) = (i, j)
      while (k < m && l < n) {
        if (matrix(k)(l) != matrix(i)(j)) return false
        k += 1
        l += 1
      }
    }
    true
  }
}