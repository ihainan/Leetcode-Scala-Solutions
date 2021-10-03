package me.ihainan

object P304 {
  class NumMatrix(_matrix: Array[Array[Int]]) {
    val sums = _matrix.indices.map { i =>
      var tmp = 0
      _matrix(i).map { num => tmp += num; tmp }
    }

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
      (row1 to row2).map { i =>
        if (col1 == 0) sums(i)(col2)
        else sums(i)(col2) - sums(i)(col1 - 1)
      }.sum
    }

  }

  /** Your NumMatrix object will be instantiated and called as such: var obj =
    * new NumMatrix(matrix) var param_1 = obj.sumRegion(row1,col1,row2,col2)
    */
}
