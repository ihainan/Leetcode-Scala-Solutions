package me.ihainan

object P1034 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def colorBorder(
      grid: Array[Array[Int]],
      row: Int,
      col: Int,
      color: Int
  ): Array[Array[Int]] = {
    val (m, n) = (grid.length, grid.head.length)
    val seen = collection.mutable.Set.empty[(Int, Int)]
    val points = collection.mutable.ArrayBuffer.empty[(Int, Int)]

    def dfs(x: Int, y: Int, c: Int): Unit = {
      var flag = false
      (0 until 4).foreach { k =>
        val (nx, ny) = (x + mx(k), y + my(k))
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid(nx)(ny) == c) {
          if (!seen((nx, ny))) {
            seen += ((nx, ny))
            dfs(nx, ny, c)
          }
        } else flag = true
      }
      if (flag) points += ((x, y))
    }

    seen += ((row, col))
    dfs(row, col, grid(row)(col))
    points.foreach { case (x, y) => grid(x)(y) = color }
    grid
  }
}
