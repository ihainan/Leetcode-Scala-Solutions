package me.ihainan

object P1380 {
  def luckyNumbers (matrix: Array[Array[Int]]): List[Int] = {
    val (m, n) = (matrix.length, matrix.head.length)
    val rows = matrix.map(_.min)
    val columns = (0 until n).map(j => (0 until m).map(i => matrix(i)(j)).max)
    val ans = collection.mutable.ListBuffer.empty[Int]
    matrix.indices.foreach { i =>
      matrix(i).indices.foreach { j =>
        if (matrix(i)(j) == rows(i) && matrix(i)(j) == columns(j)) ans += matrix(i)(j)
      }
    }

    ans.toList
  }
}