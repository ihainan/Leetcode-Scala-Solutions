package me.ihainan

object P1091 {
  val mx = Array(-1, -1, -1, 0, 0, 1, 1, 1)
  val my = Array(-1, 0, 1, -1, 1, -1, 0, 1)
  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)

    if (grid(0)(0) == 1 || grid(m - 1)(n - 1) == 1) return -1
    val queue = collection.mutable.Queue((0, 0))
    grid(0)(0) = 1
    var step = 1

    while (queue.nonEmpty) {
      val list = (0 until queue.length).map(_ => queue.dequeue)
      list.foreach { case (x, y) =>
        if (x == m - 1 && y == n - 1) return step
        (0 until 8).foreach { k =>
          val nx = x + mx(k)
          val ny = y + my(k)
          if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid(nx)(ny) == 0) {
            grid(nx)(ny) = 1
            queue.enqueue((nx, ny))
          }
        }
      }
      step += 1
    }

    -1
  }
}
