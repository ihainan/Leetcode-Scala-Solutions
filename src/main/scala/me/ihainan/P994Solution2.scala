package me.ihainan

object P994Solution2 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def orangesRotting(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val time = Array.fill(m, n)(0)
    val queue = collection.mutable.Queue.empty[(Int, Int)]

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == 2) {
          queue.enqueue((i, j))
        }
      }
    }

    while (queue.nonEmpty) {
      val (x, y) = queue.dequeue
      (0 until 4).foreach { k =>
        val (nx, ny) = (x + mx(k), y + my(k))
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid(nx)(ny) == 1) {
          time(nx)(ny) = time(x)(y) + 1
          grid(nx)(ny) = 0
          queue.enqueue((nx, ny))
        }
      }
    }

    var ans = 0
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == 1) return -1
        else ans = ans.max(time(i)(j))
      }
    }

    ans
  }
}
