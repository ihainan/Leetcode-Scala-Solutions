package me.ihainan

object P490 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def hasPath(
      maze: Array[Array[Int]],
      start: Array[Int],
      destination: Array[Int]
  ): Boolean = {
    val (m, n) = (maze.length, maze.head.length)
    val visited = collection.mutable.Set((start(0), start(1)))

    def isWall(x: Int, y: Int): Boolean =
      x < 0 || x >= m || y < 0 || y >= n || maze(x)(y) == 1

    def dfs(x: Int, y: Int): Boolean = {
      if (x == destination(0) && y == destination(1)) true
      else {
        (0 until 4).exists { i =>
          var (nx, ny) = (x, y)
          while (!isWall(nx + mx(i), ny + my(i))) {
            nx += mx(i)
            ny += my(i)
          }
          if (!visited((nx, ny))) {
            visited += ((nx, ny))
            dfs(nx, ny)
          } else false
        }
      }
    }

    dfs(start(0), start(1))
  }
}
