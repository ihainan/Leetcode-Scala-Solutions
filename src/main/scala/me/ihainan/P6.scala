package me.ihainan

object P6 {
  def convert(s: String, numRows: Int): String = {
    if (numRows == 1) return s
    val columns = collection.mutable.ArrayBuffer(Array.fill(numRows)(' '))
    var (i, direction) = (0, 1)
    s.foreach { c =>
      // println(columns.length - 1, i, c)
      columns(columns.length - 1)(i) = c
      if (i + direction == -1) {
        direction = 1
      } else if (i + direction == numRows) {
        direction = -1
      }
      i += direction
      if (direction == -1) columns += Array.fill(numRows)(' ')

    }

    val ans = new StringBuilder()
    (0 until numRows).foreach { i =>
      columns.indices.foreach { j =>
        if (columns(j)(i) != ' ') ans.append(columns(j)(i))
      }
    }
    ans.toString
  }
}
