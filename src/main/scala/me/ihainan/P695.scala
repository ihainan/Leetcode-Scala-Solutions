package me.ihainan

object P695 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    var ans = 0
    val (m, n) = (grid.length, grid.head.length)
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == 1) {
          var count = 0
          val queue = collection.mutable.Queue(i * n + j)
          grid(i)(j) = 0
          while (queue.nonEmpty) {
            val pos = queue.dequeue
            val (x, y) = (pos / n, pos % n)
            count += 1
            (0 until 4).foreach { k =>
              val (nx, ny) = (x + mx(k), y + my(k))
              if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid(nx)(ny) == 1) {
                grid(nx)(ny) = 0
                queue.enqueue(nx * n + ny)
              }
            }
          }
          ans = ans.max(count)
        }
      }
    }
    ans
  }
}
