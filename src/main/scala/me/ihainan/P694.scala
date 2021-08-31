package me.ihainan

object P694 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def numDistinctIslands(grid: Array[Array[Int]]): Int = {
    val set = collection.mutable.Set.empty[String]
    val (m, n) = (grid.length, grid.head.length)

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == 1) {
          grid(i)(j) = 0
          val queue = collection.mutable.Queue((i, j))
          val visited = collection.mutable.Set((0, 0))
          while (queue.nonEmpty) {
            val (x, y) = queue.dequeue
            visited += ((x - i, y - j))
            (0 until 4).foreach { k =>
              val (nx, ny) = (x + mx(k), y + my(k))
              if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid(nx)(ny) == 1) {
                queue.enqueue((nx, ny))
                grid(nx)(ny) = 0
              }
            }
          }

          set += visited.mkString(",")
        }
      }
    }
    set.size
  }
}