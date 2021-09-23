package me.ihainan

object P711 {
  def islandIdentity(island: Set[(Int, Int)]): String = {
    val identities = Array(
      island,
      island.map { case (x, y) => (x, -y) },
      island.map { case (x, y) => (-x, y) },
      island.map { case (x, y) => (-x, -y) },
      island.map { case (x, y) => (y, x) },
      island.map { case (x, y) => (-y, x) },
      island.map { case (x, y) => (y, -x) },
      island.map { case (x, y) => (-y, -x) }
    ).map { island =>
      val (minX, minY) = (island.map(_._1).min, island.map(_._2).min)
      island.toArray
        .map { case (x, y) => (x - minX, y - minY) }
        .sortWith { case (v1, v2) =>
          if (v1._1 != v2._1) v1._1 < v2._1
          else v1._2 < v2._2
        }.mkString(",")
    }
    identities.max
  }

  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def numDistinctIslands2(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid.length, grid.head.length)
    val islands = collection.mutable.Set.empty[String]

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == 1) {
          val visited = collection.mutable.Set((0, 0))
          val queue = collection.mutable.Queue((i, j))
          while (queue.nonEmpty) {
            val (x, y) = queue.dequeue
            (0 until 4).foreach { k =>
              val (nx, ny) = (x + mx(k), y + my(k))
              if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid(nx)(ny) == 1) {
                visited += ((nx - i, ny - j))
                queue.enqueue((nx, ny))
                grid(nx)(ny) = 0
              }
            }
          }

          val identity = islandIdentity(visited.toSet)
          if (!islands(identity)) islands += identity
        }
      }
    }

    islands.size
  }
}
