package me.ihainan

object P766 {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    val (m, n) = (matrix.length, matrix.head.length)
    val arr = (0 until m).toArray.map(i => (i, 0)) ++ (1 until n).toArray.map(j => (0, j))
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

  def main(args: Array[String]): Unit = {
    isToeplitzMatrix(Array(Array(1, 2)))
  }
}