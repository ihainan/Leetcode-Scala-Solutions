package me.ihainan

object P317Solution2 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def shortestDistance(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val ones = (0 until m).flatMap { i => (0 until n).flatMap { j => if (grid(i)(j) == 1) Some((i, j)) else None } }
    var ans = Int.MaxValue

    for {
      i <- 0 until m
      j <- 0 until n if grid(i)(j) == 0
    } {
      val queue = collection.mutable.Queue((i, j))
      val visited = collection.mutable.Set((i, j))
      var (count, step, totalStep) = (0, 0, 0)
      while (queue.nonEmpty && count != ones.size) {
        val nodes = queue.indices.map(_ => queue.dequeue)
        nodes.foreach { case (x, y) =>
          (0 until 4).foreach { k =>
            val (nx, ny) = (x + mx(k), y + my(k))
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited((nx, ny))) {
              visited += ((nx, ny))
              if (grid(nx)(ny) == 0) queue.enqueue((nx, ny))
              else if (grid(nx)(ny) == 1) {
                // if (i == 1 && j == 2) println(nx, ny, step)
                totalStep += step + 1
                count += 1
              }
            }
          }
        }
        step += 1
      }
      if (count == ones.size) ans = ans.min(totalStep)
    }

    if (ans == Int.MaxValue) -1 else ans
  }
}