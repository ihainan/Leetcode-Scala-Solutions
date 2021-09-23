package me.ihainan

object P286 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def wallsAndGates(rooms: Array[Array[Int]]): Unit = {
    val (m, n) = (rooms.length, rooms.head.length)

    def bfs(x: Int, y: Int): Int = {
      var step = 0
      val visited = collection.mutable.Set((x, y))
      val queue = collection.mutable.Queue((x, y))
      while (queue.nonEmpty) {
        val nodes = queue.indices.map(_ => queue.dequeue)
        if (nodes.exists { case (i, j) => rooms(i)(j) == 0 }) return step
        nodes.foreach { case (i, j) =>
          (0 until 4).foreach { k =>
            val nx = i + mx(k)
            val ny = j + my(k)
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited((nx, ny)) && rooms(nx)(ny) != -1) {
              visited += ((nx, ny))
              queue.enqueue((nx, ny))
            }
          }
        }
        step += 1
      }
      Int.MaxValue
    }

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (rooms(i)(j) == Int.MaxValue) {
          val step = bfs(i, j)
          rooms(i)(j) = step
        }
      }
    }
  }
}