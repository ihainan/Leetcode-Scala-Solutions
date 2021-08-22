package me.ihainan

object P499 {

  import collection.mutable

  val mx = Array(1, 0, 0, -1)
  val my = Array(0, -1, 1, 0)
  val directions = Array('d', 'l', 'r', 'u')

  def findShortestWay(maze: Array[Array[Int]], ball: Array[Int], hole: Array[Int]): String = {
    val (m, n) = (maze.length, maze.head.length)
    var buffer = new Array[Int](m * n)
    var ans = "impossible"
    val memo = mutable.Map.empty[(Int, Int), Int].withDefaultValue(Int.MaxValue)

    def isWall(x: Int, y: Int) = x < 0 || y < 0 || x >= m || y >= n || maze(x)(y) == 1

    def dfs(x: Int, y: Int, step: Int, depth: Int): Unit = {
      if (step < memo((x, y))) {
        memo((x, y)) = step
        if (x == hole(0) && y == hole(1)) ans = new String(buffer.slice(0, depth).map { i => directions(i) })
        else {
          (0 until 4).foreach { i =>
            buffer(depth) = i
            var (nx, ny) = (x, y)
            while (!isWall(nx + mx(i), ny + my(i)) && !(nx == hole(0) && ny == hole(1))) {
              nx += mx(i)
              ny += my(i)
            }
            if (x != nx || y != ny) dfs(nx, ny, step + (nx - x).abs + (ny - y).abs, depth + 1)
          }
        }
      }
    }

    dfs(ball(0), ball(1), 1, 0)
    ans
  }
}