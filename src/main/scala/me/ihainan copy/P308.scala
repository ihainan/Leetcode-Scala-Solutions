package me.ihainan

object P308 {
  class NumMatrix(_matrix: Array[Array[Int]]) {

    class BIT(_nums: Array[Int]) {
      val n = _nums.length
      val nums = new Array[Int](n + 1)
      (0 until n).foreach { i => update(i + 1, _nums(i)) }

      def update(i: Int, delta: Int): Unit = {
        if (i <= n) {
          nums(i) += delta
          update(i + (i & -i), delta)
        }
      }

      def sum(i: Int): Int = {
        if (i <= 0) 0
        else nums(i) + sum(i - (i & -i))
      }

      def range(l: Int, r: Int): Int = sum(r) - sum(l - 1)
    }

    val matrix = _matrix
    val (m, n) = (matrix.length, matrix.head.length)
    val bits = (0 until m).map(i => new BIT(matrix(i)))

    def update(row: Int, col: Int, v: Int) {
      bits(row).update(col + 1, v - matrix(row)(col))
      matrix(row)(col) = v
    }

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
      (row1 to row2).map { i => bits(i).range(col1 + 1, col2 + 1) }.sum
    }

  }

  /**
    * Your NumMatrix object will be instantiated and called as such:
    * var obj = new NumMatrix(matrix)
    * obj.update(row,col,`val`)
    * var param_2 = obj.sumRegion(row1,col1,row2,col2)
    */
}