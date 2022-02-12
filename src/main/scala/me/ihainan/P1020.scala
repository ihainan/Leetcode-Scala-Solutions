package me.ihainan

object P1020 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def numEnclaves(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length

    def bfs(i: Int, j: Int): Int = {
      val queue = collection.mutable.Queue((i, j))
      var reachEdge = (0 until 4).exists(k =>
        i + mx(k) < 0 || j + my(k) < 0 || i + mx(k) == m || j + my(k) == n
      )
      grid(i)(j) = 0
      var count = 0
      while (queue.nonEmpty) {
        val (x, y) = queue.dequeue
        count += 1
        (0 until 4).foreach { k =>
          val (nx, ny) = (x + mx(k), y + my(k))
          if (nx == -1 || ny == -1 || nx == m || ny == n) reachEdge = true
          else if (grid(nx)(ny) == 1) {
            queue.enqueue((nx, ny))
            grid(nx)(ny) = 0
          }
        }
      }
      if (reachEdge) 0 else count
    }

    var ans = 0
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == 1) ans += bfs(i, j)
      }
    }

    ans
  }
}
