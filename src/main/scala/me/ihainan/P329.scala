package me.ihainan

object P329 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    val memo = collection.mutable.Map
      .empty[(Int, Int), Int]
      .withDefaultValue(0)

    def dfs(x: Int, y: Int): Int = {
      if (memo.isDefinedAt((x, y))) memo((x, y))
      else {
        val ans = (0 until 4).map { i =>
          val (nx, ny) = (x + mx(i), y + my(i))
          if (
            nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix.head.length || matrix(
              nx
            )(ny) <= matrix(x)(y)
          ) 1
          else dfs(nx, ny) + 1
        }.max
        memo((x, y)) = ans
        ans
      }
    }

    var ans = 0
    matrix.indices.foreach { i =>
      matrix(i).indices.foreach { j =>
        ans = ans.max(dfs(i, j))
      }
    }

    ans
  }
}
