package me.ihainan

object P305 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  def numIslands2(m: Int, n: Int, positions: Array[Array[Int]]): List[Int] = {
    val parent = (0 until m * n).map(x => x).toArray
    val visited = collection.mutable.Set.empty[Int]
    var count = 0

    def find(x: Int): Int = {
      if (parent(x) != x) parent(x) = find(parent(x))
      parent(x)
    }

    def union(x: Int, y: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) {
        parent(px) = py
        count -= 1
      }
    }

    positions.map { pos =>
      val (x, y) = (pos(0), pos(1))
      val index = x * n + y
      if (!visited(index)) {
        visited += (index)
        count += 1
        (0 until 4).foreach { i =>
          val (nx, ny) = (x + mx(i), y + my(i))
          val newIndex = nx * n + ny
          if (
            nx >= 0 && nx < m && ny >= 0 && ny < n &&
            visited(newIndex) && parent(index) != parent(newIndex)
          ) {
            union(index, newIndex)
          }
        }
      }
      count
    }.toList
  }
}
