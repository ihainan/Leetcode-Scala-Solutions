package me.ihainan

object R1622 {
  def printKMoves(K: Int): List[String] = {
    val map = collection.mutable.Map.empty[(Int, Int), Char].withDefaultValue('_')
    var (left, right, up, down) = (0, 0, 0, 0)
    val mx = Array(0, 1, 0, -1)
    val my = Array(1, 0, -1, 0)
    var (x, y, current) = (0, 0, 0)

    (0 until K).foreach { _ =>
      if (map((x, y)) == 'X') {
        map((x, y)) = '_'
        current = (current - 1 + 4) % 4
      } else {
        map((x, y)) = 'X'
        current = (current + 1 + 4) % 4
      }
      x += mx(current)
      y += my(current)
      left = left.min(y)
      right = right.max(y)
      up = up.min(x)
      down = down.max(x)
    }

    val directions = Array('R', 'D', 'L', 'U')
    val ans = Array.ofDim[Char](down - up + 1, right - left + 1)
    ans.indices.foreach { i =>
      ans.head.indices.foreach { j =>
        val xx = i + up
        val yy = j + left
        ans(i)(j) = if (x == xx && y == yy) directions(current) else map((xx, yy))
      }
    }
    ans.map(_.mkString).toList
  }
}