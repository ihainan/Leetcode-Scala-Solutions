package me.ihainan

object P1036 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def isEscapePossible(
      blocked: Array[Array[Int]],
      source: Array[Int],
      target: Array[Int]
  ): Boolean = {
    if (blocked.length <= 1) return true
    val m = 1e6.toInt
    val n = blocked.size
    val set = blocked.map(b => (b(0), b(1))).toSet

    def isBlocked(x1: Int, y1: Int, x2: Int, y2: Int): Int = {
      var cnt = n * (n - 1) / 2
      val queue = collection.mutable.Queue((x1, y1))
      val visited = collection.mutable.Set((x1, y1))
      while (queue.nonEmpty && cnt >= 0) {
        val (x, y) = queue.dequeue
        cnt -= 1
        (0 until 4).foreach { i =>
          val nx = x + mx(i)
          val ny = y + my(i)
          if (
            nx >= 0 && nx < m && ny >= 0 && ny < m && !set(
              (nx, ny)
            ) && !visited((nx, ny))
          ) {
            visited += ((nx, ny))
            queue.enqueue((nx, ny))
            if (nx == x2 && ny == y2) return 0
          }
        }
      }
      if (cnt >= 0) 1 else 2
    }

    val res1 = isBlocked(source(0), source(1), target(0), target(1))
    if (res1 == 0) true
    else if (res1 == 1) false
    else isBlocked(target(0), target(1), source(0), source(1)) != 1
  }
}
