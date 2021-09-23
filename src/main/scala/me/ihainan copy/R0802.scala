package me.ihainan

object R0802 {
  var ans: List[List[Int]] = Nil

  def pathWithObstacles(obstacleGrid: Array[Array[Int]]): List[List[Int]] = {
    ans = Nil
    visit(obstacleGrid, Nil, 0, 0, obstacleGrid.length, obstacleGrid.head.length)
    ans
  }

  def visit(grid: Array[Array[Int]], path: List[List[Int]], x: Int, y: Int, m: Int, n: Int): Unit = {
    if (ans == Nil && x >= 0 && y >= 0 && x < m && y < n) {
      if (x == m - 1 && y == n - 1 && grid(x)(y) == 0) ans = path :+ List(x, y)
      else if (grid(x)(y) != 1) {
        grid(x)(y) = 1
        visit(grid, path :+ List(x, y), x + 1, y, m, n)
        visit(grid, path :+ List(x, y), x, y + 1, m, n)
        if (ans != Nil) grid(x)(y) = 0 // pruning
      }
    }
  }
}