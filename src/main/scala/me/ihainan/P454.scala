package me.ihainan

object P454 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def countSubIslands(
      grid1: Array[Array[Int]],
      grid2: Array[Array[Int]]
  ): Int = {
    val (m, n) = (grid2.length, grid2.head.length)
    var ans = 0

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid2(i)(j) == 1) {
          val visited = collection.mutable.Set((i, j))
          val queue = collection.mutable.Queue((i, j))
          while (queue.nonEmpty) {
            val (x, y) = queue.dequeue
            (0 until 4).foreach { k =>
              val (nx, ny) = (x + mx(k), y + my(k))
              if (
                nx >= 0 && nx < m && ny >= 0 && ny < n && grid2(nx)(ny) == 1
              ) {
                grid2(nx)(ny) = 0
                visited += ((nx, ny))
                queue.enqueue((nx, ny))
              }
            }
          }

          if (visited.forall { case (x, y) => grid1(x)(y) == 1 }) ans += 1
        }
      }
    }

    ans
  }
}
