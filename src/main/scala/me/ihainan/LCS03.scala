package me.ihainan

object LCS03 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def largestArea(grid: Array[String]): Int = {
    val chars = grid.map(_.toCharArray)
    val (m, n) = (grid.length, grid.head.length)

    def bfs(i: Int, j: Int): Int = {
      if (i < 0 || j < 0 || i >= m || j >= n || chars(i)(j) == 'x') return 0

      val color = chars(i)(j)
      val queue = collection.mutable.Queue((i, j))
      chars(i)(j) = 'x'
      var count = 0
      while (queue.nonEmpty) {
        val (x, y) = queue.dequeue
        count += 1
        (0 until 4).foreach { k =>
          val (nx, ny) = (x + mx(k), y + my(k))
          if (nx >= 0 && nx < m && ny >= 0 && ny < n && chars(nx)(ny) == color) {
            chars(nx)(ny) = 'x'
            queue.enqueue((nx, ny))
          }
        }
      }
      count
    }

    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) == '0') (0 until 4).foreach { k => bfs(i + mx(k), j + my(k)) }
        else if (i == 0 || j == 0 || i == m - 1 || j == n - 1) bfs(i, j)
      }
    }

    var ans = 0
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        if (grid(i)(j) != '0' && chars(i)(j) != 'x') {
          ans = ans.max(bfs(i, j))
        }
      }
    }

    ans
  }
}