package me.ihainan

object P542 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
    val (m, n) = (mat.length, mat.head.length)
    val ans = Array.fill(m, n)(0)
    val queue = collection.mutable.Queue.empty[(Int, Int)]
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (mat(i)(j) == 0) queue.enqueue((i, j))
      }
    }

    while (queue.nonEmpty) {
      val (x, y) = queue.dequeue
      (0 until 4).foreach { k =>
        val (nx, ny) = (x + mx(k), y + my(k))
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && mat(nx)(ny) == 1) {
          mat(nx)(ny) = 0
          ans(nx)(ny) = ans(x)(y) + 1
          queue.enqueue((nx, ny))
        }
      }
    }

    ans
  }
}
