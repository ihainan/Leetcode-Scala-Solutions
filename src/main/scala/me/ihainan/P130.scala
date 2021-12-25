package me.ihainan

object P130 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def solve(board: Array[Array[Char]]): Unit = {
    val (m, n) = (board.length, board.head.length)
    val seen = collection.mutable.Set.empty[(Int, Int)]

    def bfs(x: Int, y: Int): Array[(Int, Int)] = {
      val queue = collection.mutable.Queue((x, y))
      val nodes = collection.mutable.ArrayBuffer.empty[(Int, Int)]
      seen += ((x, y))
      var flag = false
      while (queue.nonEmpty) {
        val list = queue.indices.map(_ => queue.dequeue)
        list.foreach { case (x, y) =>
          nodes += ((x, y))
          (0 until 4).foreach { k =>
            val nx = x + mx(k)
            val ny = y + my(k)
            if (nx < 0 || nx == m || ny < 0 || ny == n) flag = true
            else if (board(nx)(ny) == 'O' && !seen((nx, ny))) {
              seen += ((nx, ny))
              queue.enqueue((nx, ny))
            }
          }
        }
      }

      if (flag) Array.empty[(Int, Int)]
      else nodes.toArray
    }

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (board(i)(j) == 'O' && !seen((i, j))) {
          val nodes = bfs(i, j)
          nodes.foreach { case (x, y) =>
            board(x)(y) = 'X'
          }
        }
      }
    }
  }
}
