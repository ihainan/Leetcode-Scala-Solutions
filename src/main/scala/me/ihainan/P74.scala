package me.ihainan

object P74 {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    var (i, j) = (matrix.length - 1, 0)
    while (i >= 0 && j < matrix.head.length) {
      if (matrix(i)(j) == target) return true
      else if (matrix(i)(j) > target) i -= 1
      else j += 1
    }
    false
  }
}