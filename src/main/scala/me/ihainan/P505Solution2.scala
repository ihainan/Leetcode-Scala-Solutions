package me.ihainan

object P505Solution2 {

  import collection.mutable

  val mx = Array(1, 0, -1, 0)
  val my = Array(0, 1, 0, -1)

  def shortestDistance(maze: Array[Array[Int]], start: Array[Int], destination: Array[Int]): Int = {
    val (m, n) = (maze.length, maze.head.length)

    def isWall(x: Int, y: Int) = x < 0 || y < 0 || x >= m || y >= n || maze(x)(y) == 1

    val minDist = mutable.Map.empty[(Int, Int), Int].withDefaultValue(Int.MaxValue)
    var ans = Int.MaxValue

    def dfs(x: Int, y: Int, step: Int): Unit = {
      if (minDist((x, y)) > step) {
        minDist((x, y)) = step
        if (x == destination(0) && y == destination(1)) ans = step
        else {
          (0 until 4).foreach { i =>
            var (nx, ny) = (x, y)
            while (!isWall(nx + mx(i), ny + my(i))) {
              nx += mx(i)
              ny += my(i)
            }
            if (x != nx || y != ny) dfs(nx, ny, step + (x - nx).abs + (y - ny).abs)
          }
        }
      }
    }

    dfs(start(0), start(1), 0)
    if (ans == Int.MaxValue) -1 else ans
  }
}