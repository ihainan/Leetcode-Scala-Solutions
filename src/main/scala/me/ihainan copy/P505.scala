package me.ihainan

object P505 {

  import collection.mutable

  val mx = Array(1, 0, -1, 0)
  val my = Array(0, 1, 0, -1)

  def shortestDistance(maze: Array[Array[Int]], start: Array[Int], destination: Array[Int]): Int = {
    val (m, n) = (maze.length, maze.head.length)

    def isWall(x: Int, y: Int) = x < 0 || y < 0 || x >= m || y >= n || maze(x)(y) == 1

    val memo = mutable.Map.empty[(Int, Int), Int]
    val visited = mutable.Set((start(0), start(1)))

    def dfs(x: Int, y: Int): Int = {
      if (x == destination(0) && y == destination(1)) 0
      else {
        memo.getOrElseUpdate((x, y), {
          (0 until 4).map { i =>
            var (nx, ny) = (x, y)
            while (!isWall(nx + mx(i), ny + my(i))) {
              nx += mx(i)
              ny += my(i)
            }
            if (visited((nx, ny))) Int.MaxValue
            else {
              visited += ((nx, ny))
              val res = dfs(nx, ny)
              visited -= ((nx, ny))
              if (res == Int.MaxValue) res else res + (nx - x).abs + (ny - y).abs
            }
          }.min
        })
      }
    }

    val ans = dfs(start(0), start(1))
    if (ans == Int.MaxValue) -1 else ans
  }
}