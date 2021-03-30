package me.ihainan

object O04 {
  def findNumberIn2DArray(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix.length == 0 || matrix.head.length == 0) false
    else {
      val (m, n) = (matrix.length, matrix.head.length)
      var (i, j) = (m - 1, 0)
      while (i >= 0 && j < n) {
        if (matrix(i)(j) == target) return true
        else if (matrix(i)(j) > target) i -= 1
        else j += 1
      }

      false
    }
  }
}