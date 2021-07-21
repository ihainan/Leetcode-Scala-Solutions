package me.ihainan

object P296Solution2 {
  def minTotalDistance(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val ones = (0 until m).flatMap { i => (0 until n).flatMap { j => if (grid(i)(j) == 1) Some((i, j)) else None } }
    val rows = ones.unzip._1.sorted
    val columns = ones.unzip._2.sorted
    val (x, y) = (rows((rows.length - 1) / 2), columns((columns.length - 1) / 2))
    var ans = 0
    ones.map { case (i, j) => (x - i).abs + (y - j).abs }.sum
  }
}