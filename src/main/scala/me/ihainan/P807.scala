package me.ihainan

object P807 {
  def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    var ans = 0
    val rows = grid.map(_.max)
    val columns = (0 until n).map(j => (0 until m).map(i => grid(i)(j)).max)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        ans += rows(i).min(columns(j)) - grid(i)(j)
      }
    }
    ans
  }
}
