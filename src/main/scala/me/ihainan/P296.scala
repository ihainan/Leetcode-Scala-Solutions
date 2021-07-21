package me.ihainan

object P296 {
  def minTotalDistance(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val ones = (0 until m).flatMap(i => (0 until n).flatMap(j => if (grid(i)(j) == 1) Some((i, j)) else None))
    var ans = Int.MaxValue
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        val sum = ones.map { case (x, y) => (x - i).abs + (y - j).abs }.sum
        ans = ans.min(sum)
      }
    }
    ans
  }
}