package me.ihainan

object P994 {
  val mx = Array(1, 0, -1, 0)
  val my = Array(0, 1, 0, -1)

  def orangesRotting(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    var step = 0
    val queue = collection.mutable.Queue.empty[(Int, Int)]
    var count = 0
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == 2) queue.enqueue((i, j))
        if (grid(i)(j) != 0) count += 1
      }
    }
    if (count == 0) return step

    while (queue.nonEmpty) {
      val list = (0 until queue.size).map(_ => queue.dequeue)
      count -= list.size
      step += 1
      list.foreach { case (x, y) =>
        (0 until 4).foreach { k =>
          val (nx, ny) = (x + mx(k), y + my(k))
          if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid(nx)(ny) == 1) {
            queue.enqueue((nx, ny))
            grid(nx)(ny) = 2
          }
        }
      }
    }

    if (count != 0) -1
    else step - 1
  }
}
